# thesaurus-client-server
A. Introduction to the project
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
The project is a client/server system. The client process has a simple GUI interface and will allow the user to select a word in a block of text and have the system send a query to a server to look up the word in a thesaurus file and return a list of alternative words from the server. The client process will connect to the server and send the word that the user has selected in an input text box. The server will return a string that will contain alternative words that the user might use instead of the input word. 

These alternative words will be separated by commas. The string returned for the word “abandon” might look like this: “drops, dumps, ditches, discards; deserts, leaves; ends, gives up; looses, empties, vacates, resigns, quits”. Once the client has returned a result, it will allow the user to input another word to reference against the thesaurus. The server will have a file or database that it will read to find the string of words related to the input word. It will return the associated string to the client process. It will return the string to the client and keep the connection open. The client and server will each have an Exit option that will close the program. The server process also has a GUI interface. It includes a text box which displays incoming client requests so that the user can see that the processes are communicating. It can run two clients and a single server without any problems.

B. Development 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	Programming language: Java
•	Socket programming- Client/Server
•	Server- Port number 1235.
•	SQL Db developed and connected using JDBC

C. Extra Credit Implementations  
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	Multithreaded server

D. Software Requirements
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	Eclipse Oxygen
•	JDK 8
•	Wampserver64

E. Installation 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	The mysql-connector-java-5.1.6.jar inside the lib folder of project needs to added into the build path of eclipse
•	Dictionary.sql needs to be imported into Wampserver64




F. Running the project 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 Un-RAR the folder to be imported into eclipse to test the project. dictionary.sql must be imported into Wampserver64

•	Run the com.client.server.Server.java to open server.
•	Run the com.client.server.Client.java to open client(s).
•	Start the Wampserver64 having the dictionary.sql database file

G. Testing & Output
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	Upon running the server code, the GUI must display that server is up and running
•	After running the client, GUI must ask you to enter a block of text, select the word to 
fetch the synonym.
•	It shall display the set of synonyms for the selected word.
•	Ex: This is a test. Upon selecting the word “test”, it will generate the synonyms as
“trial”, “examination”, “experiment”, “assay”, “try”, “proof”. 

H. Limitations
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	The application does not have the entire thesaurus, but has a fixed set of word lists.
For ex: abandon, brave, calm, dangerous, decide, eager, explain, wrong, valid.

