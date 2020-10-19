# Address-Book-to-Google-Earth-Project
Convert text file addresses to coordinates, then to be plotted in Google Earth 

# Prerequesites

Java 1.8
Google Earth Pro Desktop app
Java Home path is set properly
A google api key that is associated with a billing account, has geolocation api enabled, and geocoding api enabled

# How to operate

- Insert your google api key into address_book.java for the variable 'key'
- Add addresses you desire to the file 'address_book.txt' (located in google-maps/src/google/maps)
- Run main.java (whether you compile it via command line, through eclipse, export as .jar, etc.)
- Retrieve the coordinates.txt file (located in google-maps/src/google/maps)
- Open the Google Earth Desktop
- Click file, import, import the coordinates.txt file, ensure the delimiter is comma, the headers are longitude and lattitude, the values are float values, and you can further       change the styles of the plots (icons, colours, etc.)
- If the points do not initially show, ensure you have checked the box on the bottom left for coordinates.txt

# Author

Malcolm Tsai
