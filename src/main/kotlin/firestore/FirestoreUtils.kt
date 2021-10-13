package firestore

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import objects.Flight
import objects.Plane
import objects.User


object FirestoreUtils {
    //gestionrequerimientos-d0480-6daae4c6546e.json
    val USER_COLLECTION = "users"
    val AIRLINES_COLLECTION = "airlines"
    val FLIGHT_SEATS_COLLECTION = "flightSeats"
    val FLIGHTS_COLLECTION = "flights"
    val PLANE_SEATS_COLLECTION = "planeSeats"
    val PLANES_COLLECTION = "planes"
    val TICKETS_COLLECTION = "tickets"
    val COUNTRIES_COLLECTION = "countries"


    val PROJECT_COLLECTION = "projects"
    val CATALOG_COLLECTION = "catalogs"

    //val local = "src/main/webapp/"
    const val local = ""

    //GENERAL METHODS
    fun initFirestore() : Firestore {
        val credentials = GoogleCredentials.getApplicationDefault()
        val options = FirebaseOptions.Builder()
            .setCredentials(credentials)
            .build()

        if (FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options)
        }

        return FirestoreClient.getFirestore()
    }

    fun insertObjectWithRandomDocumentID(collection : String, obj : Any) : String{
        val db = initFirestore()
        val future = db.collection(collection).add(obj)
        return future.get().id
    }

    fun deleteDocumentWithId(collection: String, documentID : String){
        val db = initFirestore()
        db.collection(collection).document(documentID).delete()
    }

    fun getCatalog(document : String) : List<String>{
        val db = initFirestore()
        val categories = db.collection(CATALOG_COLLECTION).document(document)
        val res = categories.get().get()
        return res["catalog"] as List<String>
    }

    inline fun <reified T : Any> getObjectList(collection  : String) : List<T>{
        val db = initFirestore()
        val future = db.collection(collection).get()
        val documents = future.get().documents
        val responseList = arrayListOf<T>()
        documents.map { responseList.add(it.toObject(T::class.java)) }
        return responseList
    }

    inline fun <reified T : Any> getObject(collectionId  : String, documentId: String) : T?{
        val db = initFirestore()
        val document = db.collection(collectionId).document(documentId).get().get()
        return document.toObject(T::class.java)
    }

    fun updateDocumentWithObject(collection: String, documentId: String, obj : Any){
        val db = initFirestore()
        db.collection(collection).document(documentId).set(obj)
    }

    //CASE SPECIFIC METHODS
    fun getUserWithCredentials(email : String, password : String) : User?{
        val db = initFirestore()
        val querySnapshot = db.collection(USER_COLLECTION)
            .whereEqualTo("email", email)
            .whereEqualTo("password", password).get()

        val resp = querySnapshot.get().documents.firstOrNull()

        resp?.let {
            return it.toObject(User::class.java)
        }
        return null
    }

    fun getFlights(origin : String, destination : String, departureDate : String?, arrivalDate : String?, classType : String) : List<Flight>{
        val result = arrayListOf<Flight>()

        val db = initFirestore()
        val query = db.collection(FLIGHTS_COLLECTION)
            .whereEqualTo("origin", origin)
            .whereEqualTo("destination", destination)


        if (!departureDate.isNullOrEmpty()){
            query.whereEqualTo("departureDate", departureDate)
        }

        if (!departureDate.isNullOrEmpty() && !arrivalDate.isNullOrEmpty()){
            query.whereEqualTo("arrivalDate", arrivalDate)
        }

        query.get().get().documents.map {
            val flight = it.toObject(Flight::class.java)

            val plane = db.collection(PLANES_COLLECTION).get().get().documents.first().toObject(Plane::class.java)
            flight.planeObj = plane
            flight.id = it.id

            result.add(flight)
        }

        return result
    }
}