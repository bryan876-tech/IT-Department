package com.itdepartment.utils

import android.app.Activity
import android.content.ContentValues
import android.content.Context.MODE_PRIVATE
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.itdepartment.models.Course
import com.itdepartment.models.Faculty
import java.util.UUID

class InitializeData(private val activity: Activity) {

    fun init(){
//        val sharedPreferences = activity.getSharedPreferences("AppPrefs", MODE_PRIVATE)
//        val isInitialized = sharedPreferences.getBoolean("data_initialized", false)
//        if (!isInitialized){
//            InitializeFacultyData()
//            with(sharedPreferences.edit()) {
//                putBoolean("data_initialized", true)
//                apply()
//            }
//        } else {
//            // Data is already initialized
//            Log.d("Firestore", "Faculty data has already been initialized.")
//        }
        InitializeCoursesData()
    }


    private fun InitializeFacultyData(){

            val list: MutableList<Faculty> = ArrayList()

            if (list.isEmpty()) {
                list.add(Faculty("Natalie Rose", "ithod@ucc.edu.jm", "+1 876 906-3000", "https://jamaica-gleaner.com/sites/default/files/styles/jg_article_image/public/media/article_images/2018/11/22/NatalieRoseA20181120LR.jpg?itok=40nQ29hP",UUID.randomUUID().toString()))
                list.add(Faculty("Otis Osbourne", "itfaculty@ucc.edu.jm", "+1 876 906-3000", "https://pbs.twimg.com/profile_images/1389979286854115329/p8KFeFpb_400x400.jpg",UUID.randomUUID().toString()))
                list.add(Faculty("Neil Williams", "itlecturer@ucc.edu.jm", "+1 876 906-3000", "https://img1.wsimg.com/isteam/ip/fde9f60c-773a-4e67-acd2-19344071b213/Neil%20Williams.jpg/:/rs=w:365,h:365,cg:true,m/cr=w:365,h:365",UUID.randomUUID().toString()))
                list.add(Faculty("Dr. Sajjad Rizvi", "srizvi@faculty.ucc.edu.jm", "+1 876 906-3000", "https://d2cax41o7ahm5l.cloudfront.net/mi/ocm/appliedphysics-mathematics-dr-syed-sajjad-hussain-rizvi-450678932.jpg",UUID.randomUUID().toString()))
                list.add(Faculty("Henry Osborne", "hosbourne@ucc.edu.jm", "+1 876 906-3000", "https://pbs.twimg.com/profile_images/1277350205873061888/e372ox-5_400x400.jpg",UUID.randomUUID().toString()))
                list.forEach { insertUserInfo(it) }



        }
    }
    private fun insertUserInfo(faculty: Faculty) {
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("faculty").document(faculty.id as String)

        docRef.set(faculty)
            .addOnSuccessListener {
                Log.d("Firestore", "DocumentSnapshot successfully written!")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error writing document", e)
            }
    }

    private fun InitializeCoursesData(){

//        deleteAllDocumentsFromCollection("courses")
        val list: MutableList<Course> = ArrayList()
        if (list.isEmpty()) {
            list.add(Course("ITT101", "Computer Information Systems", 3, "None",
                "This introductory course aimed to provide a foundation level understanding of Information Technology.\n" +
                        "The main concepts covered the identification and explanation of basic computer components, set up a basic workstation, " +
                        "conduct of basic software installation, establishment of basic network connectivity, " +
                        "the identification of compatibility issues and the prevention of basic security risks.\n" +
                        "In the practical section of the course students will get hands-on experience using office productivity tools and setup a basic workstation.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT103", "Programming Techniques", 3, "Computer Information Systems",
                "This course will introduce students to programming concepts. Students will learn proper programming design techniques and " +
                        "principles. The focus is on developing the logic and thought-processes required for problem solving, rather than on learning a programming language.\n" +
                        "This course assumes no prior knowledge of programming; however successful students will be those with an aptitude for problem-solving.\n" +
                        "Programming Techniques serves as the foundation course for all other programming courses in the programme.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT200", "Object Oriented Programming using C++", 3, "Programming Techniques",
                "This course aims to broaden the student's knowledge of concepts and features of an object-oriented programming language.\n" +
                        "Students will be required to use these concepts to design solutions for real world problems.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT300", "Discrete Mathematics II", 3, "Discrete Mathematics I",
                "This course builds on the fundamentals of discrete mathematics covered in Discrete Structures I.\n" +
                        "The main focus will be on developing a sound theoretical foundation for further work in computer science and information science.\n" +
                        "The topics covered in this course will not be exhaustive to discrete structures but will provide the basis for " +
                        "pursuing other advanced courses in discrete structures and mathematics.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT304", "Database Management Systems II", 3, "Database Management Systems I",
                "This course is aimed at providing upper level undergraduate students with intermediate to " +
                        "advanced concepts in data modelling design and database administration.\n" +
                        "The course explores the variety of options available in database development and administration for " +
                        "current and future use on particular software platform technologies.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT308", "Internet Authoring II", 3, "Internet Authoring I",
                "This course continues from Internet Authoring I, covering some of the same topics in more depth.\n" +
                        "This course includes coverage of topics in networking technologies for the web, web " +
                        "UI design and site design, client-server architecture and client-side and server-side programming.\n" +
                        "It covers relevant topics in ecommerce, web security, and engineering concepts such as the three-tier architecture and frameworks for the web.\n" +
                        "It provides an introduction to mobile web issues and web multimedia.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT309", "Computer Security", 3, "Data Communication & Network II",
                "This course is designed to provide an understanding of computer security and " +
                        "prepare students for the CompTIA Security+ exam.\n" +
                        "The course covers material related to general computer security concepts, communications security, infrastructure " +
                        "security, basics of cryptography and operational/organizational security.\n" +
                        "Students gain knowledge in basic cryptography, fundamentals of computer and network " +
                        "security, risks faced by computers and networks, security mechanisms, operating " +
                        "system security and secure systems design principles.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT323", "IT Capstone Project II", 3, "IT Capstone Project I",
                "A supervised group assignment in the development of information technology infrastructure for an organization.\n" +
                        "Students select an organization whose IT needs are not well-addressed, and design a completely " +
                        "integrated system including IT administration structure, hardware, software, and technology needs.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT401", "Intelligent Systems", 3, "Discrete Mathematics II",
                "The course focuses on the basic concepts and methods in artificial \"societies\" and complex systems.\n" +
                        "It will concentrate on artificial intelligence, cognitive science, and the social context of intelligent systems.\n" +
                        "It will provide an understanding of the application of intelligent systems in the industry and organization.\n" +
                        "In particular, it will focus on how these systems may be used to assist in the " +
                        "decision-making process within the organization.",UUID.randomUUID().toString()
            ))
            list.add(Course("ITT405", "Human Computer Interaction & Interface Design", 3, "Introduction to Psychology, Systems Analysis & Designs I",
                "This course provides an introduction to the field of human-computer interaction (HCI), an " +
                        "interdisciplinary field that integrates cognitive psychology, design, computer science and others.\n" +
                        "Examining the human factors associated with information systems provides the students with knowledge to understand " +
                        "what influences usability and acceptance of Information Systems (IS). This course will examine human performance, components of " +
                        "technology, methods and techniques used in design and evaluation of IS.\n" +
                        "Societal impacts of HCI such as accessibility will also be discussed.\n" +
                        "User-centered design methods will be introduced and evaluated.\n" +
                        "This course will also introduce students to the contemporary technologies used in empirical evaluation methods.",UUID.randomUUID().toString()
            ))
            list.forEach { insertCourseInfo(it) }
        }
    }

    private fun insertCourseInfo(course: Course) {
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("courses").document(course.id as String)

        docRef.set(course)
            .addOnSuccessListener {
                Log.d("Firestore", "DocumentSnapshot successfully written!")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error writing document", e)
            }
    }


    private fun deleteAllDocumentsFromCollection(collectionName: String) {
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection(collectionName)

        // Get all documents in the collection
        collectionRef.get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    // Create a batch to perform deletions
                    val batch = db.batch()
                    for (document in querySnapshot.documents) {
                        batch.delete(document.reference)
                    }

                    // Commit the batch
                    batch.commit()
                        .addOnSuccessListener {
                            // Handle successful deletion
                            println("All documents deleted successfully.")
                        }
                        .addOnFailureListener { e ->
                            // Handle error
                            println("Error deleting documents: ${e.message}")
                        }
                } else {
                    println("No documents found to delete.")
                }
            }
            .addOnFailureListener { e ->
                // Handle error
                println("Error fetching documents: ${e.message}")
            }
    }
}