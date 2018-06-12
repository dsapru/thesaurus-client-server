# thesaurus-client-server
A. Development 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	Programming language: Java
•	Socket programming- Client/Server
•	Server- Port number 1235.
•	SQL Db developed and connected using JDBC

B. Running the project 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 Un-RAR the folder to be imported into eclipse to test the project. dictionary.sql must be imported into Wampserver64

•	Run the com.client.server.Server.java to open server.
•	Run the com.client.server.Client.java to open client(s).
•	Start the Wampserver64 having the dictionary.sql database file

C. Testing & Output
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	Upon running the server code, the GUI must display that server is up and running
•	After running the client, GUI must ask you to enter a block of text, select the word to 
fetch the synonym.
•	It shall display the set of synonyms for the selected word.
•	Ex: This is a test. Upon selecting the word “test”, it will generate the synonyms as
“trial”, “examination”, “experiment”, “assay”, “try”, “proof”. 

D. Limitations
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
•	The application does not have the entire thesaurus, but has a fixed set of word lists.
For ex: abandon, brave, calm, dangerous, decide, eager, explain, wrong, valid.

