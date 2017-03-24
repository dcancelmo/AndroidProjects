package assignment06.csc214.homework6_listrecyclerviews.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dan on 3/22/17.
 */

public class Schedule {
    private static Schedule sSchedule;
    private Context mAppContext;
    private Map<Integer, Course> sMapSchedule;

    private Schedule(Context appContext) {
        mAppContext = appContext;
        sMapSchedule = new HashMap<>();
        addCourse("CSC Computation and Formal Systems", 173, "Ferguson", "Investigation of several formal systems influential in computer science, and also some of their applications (e.g. inspiring and providing the foundation for a computer programming style, or providing the basis for solving important practical problems like communications protocols, compiling, systems analysis, graphics ...)");
        addCourse("CSC Computer Organization", 252, "Ipek", "Introduction to computer architecture and the layering of hardware/software systems. Topics include instruction set design; logical building blocks; computer arithmetic; processor organization; the memory hierarchy (registers, caches, main memory, and secondary storage); I/O—buses, devices, and interrupts; microcode and assembly language; virtual machines; the roles of the assembler, linker, compiler, and operating system; technological trends and the future of computing hardware. Several programming assignments required.");
        addCourse("CSC Android Mobile App Dev", 214, "StJacques", "Coursework covers user interface designs and functional algorithms for mobile devices (Android) and unique user interactions using multi-touch technologies. Object-oriented design using model-view-controller paradigm, memory management. Other topics include: object-oriented database API, animation, multi-threading and performance considerations");
        addCourse("HIS War, Money, and Ordinary People: European History 1492-1789", 223, "Outram", "This course covers topics such as the changing nature of warfare, the lives of ordinary people, and how the state attempted to control their private lives. It also looks at the global world which had emerged along with the growth of globalism.");
        addCourse("CSC Principles of Web Application Development", 210, "StJacques", "The World Wide Web was born around 1990, so it is not much older than most of you. In this course, we will follow the growth of the Web from its toddler years, to early childhood, to its turbulent pre-teen and teenage years, and finally as it begins to mature as a young adult. Along this journey, you will learn influential Web technologies such as HTTP, HTML, JavaScript, CSS, the LAMP stack, XML, JSON, Ajax, WebSockets, and modern MVC frameworks. Even though you will be doing a lot of programming in this course, its purpose is not to teach you to become an expert in any particular language or framework. Web technologies change at a blistering pace, so specifics quickly get outdated. However, once you take this course and understand the fundamentals, you will be able to easily pick up new technologies on the fly.");
        addCourse("CSC Artificial Intelligence", 242, "Ferguson", "Introduces fundamental principles of artificial intelligence, including heuristic search, automated reasoning, handling uncertainty, and machine learning. Presents applications of AI techniques to real-world problems such as understanding the web, computer games, biomedical research, and assistive systems. This course is a prerequisite for advanced AI courses.");
        addCourse("AH Creating Architecture- An Introduction", 114, "Ashenfelder; Wolfe", "Buildings are among the most public, visible & long lived artifacts that a culture creates. The built environment serves as both a repository of cultural information & exerts an influence that extends beyond the society that created it. This introductory course will explore a visual survey of Architecture from Ancient Times to the present day using a slide lecture & discussion format that will invite each student to participate in the discourse of the class. The studio portion of this course will provide students an opportunity to create their own structures from sketch to 3 dimensional pieces exploring basic design elements & materials. No prior studio experience is necessary.");
        addCourse("HIS British Imperialism", 330, "Ferguson", "This seminar is an upper-level introduction to the history of British imperialism and colonialism from the 17th century to the present. Drawing on a variety of primary and secondary materials, we will explore such subjects as geographical exploration (from the South Seas to the Himalaya), colonial settlement and trade, the effects of empire on nature and environment, imperial psychology, imperial culture, gender and empire, decolonization, and the legacy of the British empire in Africa, Asia, and elsewhere. Readings will include classic works by Hobson and Lenin as well as novels, colonial memoirs, and histories. Our format will consist of a mix of informal lectures and discussions and the occasional documentary film. Short response papers and a final research paper (or alternative project) are required.");
        addCourse("CSC Design & Analysis of Efficient Algorithms", 282, "Stefankovic", "How does one design programs and ascertain their efficiency? Divide-and-conquer techniques, string processing, graph algorithms, mathematical algorithms. Advanced data structures such as balanced tree schemes. Introduction to NP-completeness and intractable combinatorial search, optimization, and decision problems.");
        addCourse("CSC Computer Models & Limitations", 280, "Hemaspaandra", "This course studies fundamental computer models and their computational limitations. Finite-state machines and pumping lemmas, the context-free languages, Turing machines, decidable and Turing-recognizable languages, undecidability.");
        addCourse("WRT Communicating Your Professional Identity in Engineering", 273, "Lee", "This interactive course teaches “real life” communication skills and strategies that help students present their best professional selves and develop a fulfilling career. Students will explore and articulate their internship, career and graduate school goals for distinct audiences and purposes as they develop a professional communication portfolio of materials such as resumes, cover letters, statements of purpose, electronic communications, elevator pitches, project descriptions and abstracts, and online profiles (i.e., LinkedIn). Students will revise and refine their written and spoken work across the semester based on feedback from peers, instructors, and alumni. By the semester’s end, students will have gained extensive experience with the communication skills expected in today’s competitive environment.");
        addCourse("CSC Programming Language Design & Implementation", 254, "Scott", "Design and implementation of programming languages, with an emphasis on imperative languages and on implementation tradeoffs. In-depth examination of \"how programming languages work.\" Topics include fundamental language concepts (names, values, types, abstraction, control flow); compilation and interpretation (syntactic and semantic analysis, code generation and optimization); major language paradigms (imperative, object-oriented, functional, logic-based, concurrent). Course projects include assignments in several different languages, with an emphasis on compilation issues.");
        addCourse("CSC Computational Introduction to Statistics", 262, "Almudevar", "This course will cover foundational concepts in probability and statistical inference, with an emphasis on topics of interest to computer scientists. Following an introduction to elementary probability theory, topics will include applications of combinatorics; Markov chains; principles of statistical classification (Bayes' rule, sensitivity and specificity, ROC curves) and random number generation. The theory of statistical estimation and hypothesis testing will be introduced, and applied to one and two sample inference for population means, proportions, variances and correlations. Nonparametric procedures will be discussed. Topics also include statistical modeling (ANOVA, simple and multiple regression), and computational methods. Students will be introduced to the R statistical computing environment.");
        addCourse("CSC Web Design and Development", 170, "Kostin", "An introduction to Internet and Web technologies. Topics include Internet transport protocols, HTML5 and CSS3, Web page design and Website publishing. Emphasis is placed on fundamentals, design concepts and industry standards. Additional topics include: web site construction techniques, mobile design issues, and Search Engine Optimization (SEO). Programming with JavaScript will be introduced.");
        addCourse("CSC The Science of Programming", 171, "StJacques", "Hands-on introduction to programming using the Java programming language. Teaches fundamentals of programming and more advanced topics. Emphasizes algorithmic thinking and computational problem solving and provides an introduction to the concepts and methods used in Computer Science. Required for all CSC majors. Lab and workshop required");
        addCourse("CSC Data Structure and Algorithms", 172, "Pawlicki", "Abstract data types (e.g., sets, mappings, and graphs) and their implementation as concrete data structures in Java. Analysis of the running times of programs operating on such data structures, and basic techniques for program design, analysis, and proof of correctness (e.g., induction and recursion).");
        addCourse("CSC Adv Front End Web Development", 174, "Kostin", "\"Front-end\" is an industry term that refers to the focus on HTML, CSS and JavaScript, which differentiates this course from the formal programming courses. Topics will include Information Architecture, visual design, use of client libraries (mostly JS), and asset management strategies; we will also cover Content Management Systems and introduce web databases using PHP and MySQL.");
        addCourse("CSC Human Computer Interaction", 212, "Hoque", "This course will explore the design, implementation, and evaluation of user interfaces. Students will study the theoretical methods for interface design and evaluation, including requirements gathering, usability heuristics, user interface inspections, usability studies, information visualization, and prototyping. Case studies of interface successes and failures will augment theory with practical experiences. Students will apply this methodology to assignments in the design, implementation, and evaluation cycle.");
        addCourse("HIS History of India", 139, "Weaver", "An introductory survey of the history of India from ancient times to the present, with a special emphasis on the British colonial era and the making of the Indian nation. Course readings will emphasize India's remarkable religious, cultural, and environmental diversity and the challenges and promises that such diversity presents to national identity in the world's most populous democracy. Course format will be an informal mix of lectures, discussions, student presentations, and films.");
        addCourse("HIS History of England & Ireland", 229, "Weaver", "This course is an introductory survey of the tragically intermingled histories of England and Ireland from the Tudor succession to the present. Topics include the English Reformation, the English Civil War and Revolution, the settlement of Ireland, revolution and Irish nationalism, the Great Famine, the Irish emigration, Victorian reform, the two world wars, and the \"Troubles\" (old and new). Course consists of lectures, small group discussion, and a few films.");
    }

    public void addCourse(String mCourseName, int mCourseNum, String mInstructor, String mDescription) {
        Course mNewCourse = new Course(mCourseName, mCourseNum, mInstructor, mDescription);
        sMapSchedule.put(mNewCourse.getCourseNum(), mNewCourse);
    }

    public Course getCourse (int mCourseNum) {
        return sMapSchedule.get(mCourseNum);
    }

    public List<Course> getSchedule() {
        List<Course> mSchedule = new ArrayList<>(sMapSchedule.size());
        mSchedule.addAll(sMapSchedule.values());
        Collections.sort(mSchedule, new ScheduleComparator());
        return mSchedule;
    }

    public static Schedule get(Context mContext) {
        if(sSchedule == null) {
            sSchedule = new Schedule(mContext);
        }
        return sSchedule;
    }
}
