package firestore

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.Query
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import objects.*


object FirestoreUtils {
    //gestionrequerimientos-d0480-6daae4c6546e.json
    val USER_COLLECTION = "users"
    val AIRLINES_COLLECTION = "airlines"
    val FLIGHT_SEATS_COLLECTION = "flightSeats"
    val FLIGHTS_COLLECTION = "flights"
    val PLANES_COLLECTION = "planes"
    val TICKETS_COLLECTION = "tickets"
    val COUNTRIES_COLLECTION = "countries"
    val GROUP_TICKET_BUY = "groupTicketBuy"

    val PROJECT_COLLECTION = "projects"
    val CATALOG_COLLECTION = "catalogs"

    val db : Firestore by lazy {
        val credentials = GoogleCredentials.getApplicationDefault()
        val options = FirebaseOptions.Builder()
            .setCredentials(credentials)
            .setProjectId("aeromaya")
            .build()

        if (FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options)
        }

        FirestoreClient.getFirestore()
    }

    fun insertObjectWithRandomDocumentID(collection : String, obj : Any) : String{
        val future = db.collection(collection).add(obj)
        return future.get().id
    }

    fun deleteDocumentWithId(collection: String, documentID : String){
        db.collection(collection).document(documentID).delete()
    }

    fun getCatalog(document : String) : List<String>{
        val categories = db.collection(CATALOG_COLLECTION).document(document)
        val res = categories.get().get()
        return res["catalog"] as List<String>
    }

    inline fun <reified T : Any> getObjectList(collection  : String) : List<T>{
        val future = db.collection(collection).get()
        val documents = future.get().documents
        val responseList = arrayListOf<T>()
        documents.map { responseList.add(it.toObject(T::class.java)) }
        return responseList
    }

    inline fun <reified T : Any> getObjectWithId(collectionId  : String, documentId: String) : T?{
        val document = db.collection(collectionId).document(documentId).get().get()
        return document.toObject(T::class.java)
    }

    inline fun <reified T : Any> getObjectListWithQuery(collectionId: String, vararg queryList : FirestoreQuery) : List<T>{
        val result = arrayListOf<T>()
        var collection : Query = db.collection(collectionId)
        queryList.forEach { query ->
            query.expectedStringValue?.let {
                collection = collection.whereEqualTo(query.firestoreKey, it)
            }

            query.expectedBooleanValue?.let {
                collection = collection.whereEqualTo(query.firestoreKey, it)
            }

            query.expectedNumericValue?.let {
                collection = collection.whereEqualTo(query.firestoreKey, it)
            }
        }
        collection.get().get().documents.map {
            result.add(it.toObject(T::class.java))
        }
        return result
    }

    inline fun <reified T : Any> getObjectWithQuery(collectionId  : String, vararg queryList : FirestoreQuery) : T?{
        var collection : Query = db.collection(collectionId)
        queryList.forEach { query ->
            query.expectedStringValue?.let {
                collection = collection.whereEqualTo(query.firestoreKey, it)
            }

            query.expectedBooleanValue?.let {
                collection = collection.whereEqualTo(query.firestoreKey, it)
            }

            query.expectedNumericValue?.let {
                collection = collection.whereEqualTo(query.firestoreKey, it)
            }
        }
        return collection.get().get().documents.firstOrNull()?.toObject(T::class.java)
    }

    fun updateDocumentWithObject(collection: String, documentId: String, obj : Any) = db.collection(collection).document(documentId).set(obj)
}