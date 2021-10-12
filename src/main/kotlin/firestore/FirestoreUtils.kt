package firestore

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.Query
import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import objects.Issue
import objects.Project
import objects.User
import java.io.FileInputStream


object FirestoreUtils {
    //gestionrequerimientos-d0480-6daae4c6546e.json
    val USER_COLLECTION = "users"
    val PROJECT_COLLECTION = "projects"
    val ISSUE_COLLECTION = "issues"
    val ROLE_COLLECTION = "roles"
    val CATALOG_COLLECTION = "catalogs"

    val DEPARTMENTS_DOCUMENT = "departments"
    val ISSUE_CAT_DOCUMENT = "issue_categories"

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

    fun insertObjectWithRandomDocumentID(collection : String, obj : Any){
        val db = initFirestore()
        val future = db.collection(collection).document().set(obj)
        println(future.get().updateTime)
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
        } ?: run {
            return null
        }
    }
}