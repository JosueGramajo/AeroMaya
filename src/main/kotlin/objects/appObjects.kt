package objects

import com.google.cloud.firestore.annotation.Exclude

data class User(
    val email : String,
    val password : String,
    val role : Int
){
        constructor() : this("", "", 0)
}

data class Project(
        val name : String,
        val description : String,
        var percentageFinished : Double,
        val startDate : String,
        val estimatedEndDate : String,
        val endDate : String,
        val cost : Double,
        val personInCharge : String,

        @Exclude var id : String
){
        constructor() : this("", "", 0.00, "", "", "", 0.00, "", "")
}

data class ProjectParsedData(
        var baseProject : Project,
        var remainingTime: Int,
        var completedTasks: String
){
        constructor() : this(Project(), 0, "")
}

data class Issue(
        val number : Int,
        val title : String,
        val description: String,
        val projectId : String,
        val startDate : String,
        val estimatedEndDate : String,
        val endDate : String,
        val category : String,
        val stage : String,
        val technician : String,
        val technicianId: String,
        val tasks : List<Task>,
        @Exclude var id : String,
        @Exclude var image : String
){
        constructor() : this(0, "", "", "", "", "", "", "", "", "", "", arrayListOf(),"", "")
}

data class IssueParsedData(
        var baseIssue : Issue,
        var completedTasks : String,
        var percentageCompleted : Int,
        var remainingTime : Int
){
        constructor() : this(Issue(), "", 0, 0)
}

data class Task(
        val id: String,
        val description: String,
        var completed: Boolean
){
        constructor() : this("", "", false)
}

data class Role(
        val id : Int,
        val name : String
){
        constructor() : this(0, "")
}

data class Statistics(
        val users : Int,
        val projects : Int,
        val issues : Int,
        val issuesResolved : Int,

        val usersIssues : List<UserIssue>
){
        constructor() : this(0,0,0,0, arrayListOf())

        data class UserIssue(
                val userName : String,
                val totalIssues : Int,
                val backlogIssues : Int,
                val pendingIssues : Int,
                val inProgressIssues : Int,
                val qaIssues : Int,
                val finishedIssues : Int
        ){
                constructor() : this("",0, 0, 0, 0, 0, 0)
        }
}