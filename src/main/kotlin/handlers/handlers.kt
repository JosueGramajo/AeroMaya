import firestore.FirestoreUtils
import objects.User
import utils.Companion

object UserHandler{
    fun authenticateUser(email : String, password : String) : Boolean{
        val user = FirestoreUtils.getUserWithCredentials(email, password)

        user?.let {
            Companion.currentUser = it
            return true
        }

        return false
    }
}