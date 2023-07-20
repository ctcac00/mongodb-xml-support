# XML to MongoDB Converter

This Java application allows you to convert XML data into JSON format and store it in a MongoDB database. It utilizes the provided MongoDB URI and an XML input file as command-line arguments to execute the conversion and storage process.

## Requirements

- Java (JDK 8 or higher)
- MongoDB

## How to Use

1. Clone the repository:

   ```shell
   git clone <repository_url>
   cd <repository_directory>
   ```

2. Build the project using Gradle:

   ```shell
   ./gradlew build
   ```

3. Run the application with the MongoDB URI and XML input file as arguments:

   ```shell
   ./gradlew run --args="<MongoDB_URI> <XML_input_file>"
   ```

   Replace `<MongoDB_URI>` with the URI to your MongoDB instance and `<XML_input_file>` with the path to the XML file you want to convert and store.

## Program Flow

1. The program checks if two command-line arguments are provided. If not, it displays an error message indicating the correct usage and exits gracefully.

2. If two arguments are provided, the application proceeds with the following steps:

   - Reads the XML input file and stores its content as a string.
   - Converts the XML string to JSON format using the `org.json.XML` library.
   - Compresses the original XML string into a binary zipped format using `CompressionUtils.compress()`.
   - Creates a MongoDB document containing the JSON data and the originalXML as additional fields.
   - Inserts the document into the specified MongoDB database and collection.
   - Retrieves the inserted document from the database and logs its content.
   - Decompresses the binary zipped XML data and logs the original XML.

## Dependencies

- [MongoDB Java Driver](https://mongodb.github.io/mongo-java-driver): The MongoDB Java driver is used to connect and interact with the MongoDB database.

- [org.json.XML](https://stleary.github.io/JSON-java/org/json/XML.html): The JSON-java library is used to convert XML data to JSON format.

## Note

- The provided MongoDB URI should be valid and accessible to the application.
- The Gradle build tool handles the compilation and execution of the application using the specified dependencies.
- Make sure you have JDK 8 or higher installed on your system.
