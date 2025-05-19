1) Cleaning
2) Add outfit font to index.css
3) Change the title of the project
4) Change the favicon

SETUP THE TAILWIND CSS - Development Steps
------------------------------------------
1) Install tailwind css via npm
    npm install tailwindcss @tailwind/vite

2) configure the vite plugin
    inside vite.config.js
    we import vite and import tailwindcss from '@tailwindcss/vite'
    plugins: [
        tailwindcss(),
    ]

3) Import the tailwind css in global style sheet
    @import 'tailwindcss'

4) Test the integration
    add the tailwind css classes


SETUP THE MENUBAR - Development Steps
--------------------------------------
1) install lucid-react for icons as dependency pass the props like color etc
    npm install lucide-reactf

2) create assets.js file and export images


3) Create the menu bar componenet and update the content
4) Mount the menu component inside the app component
5) Test the changes inside the browser


Development Steps
-----------------
1) Understand how to structure the landing page
    all wrapped by home component
    Home Component
        header component
        BgRemovalSteps
        BgSlider
        Pricing
        Testimonials
        TryNow
2) Create the all the necessary components and update the content
3) Create Home Component and mount all other components
4) Test the changes inside browser


Making BgRemovalSteps
---------------------
1) Update the assets.js file
2) Create the BgRemovalSteps Component
3) Update the home component


BgSlider
--------
1) Update the assets.js file
2) Create the BgSlider component
3) Update the background slider
4) Update the home component



Plans
-----
1) Update the assets.js file using plans
2) Create the pricing component
3) Update the pricing component

Testimonials
------------
1) Update the assets.js file
2) Create new component testimonials
3) Update the home conponent

TryNow
------
1) Create new component try now
2) Update the home component


SETUP FOR ROUTING & TOAST NOTIFICATION
--------------------------------------
Dev Steps

1) Install the required dependencies: react-router-dom and react-hot-toast
    npm install react-router-dom react-hot-toast
2) Update the main.jsx file to include the BrowserRouter Component
3) Update the App component to configure the routes
4) Update the Menubar component


CLERK
-----
1) Create a free account in clerk
2) Create a new application in clerk and configure the sign in options
3) Get the publisable key
4) Update Main.jsx to include the ClerkProvide Component
5) Update the MenuBar component to include the clerk provided componenets
6) Test the changes inside browser


<!-- Development steps for backend spring boot -->
DEVELOPMENT STEPS
-----------------
1) Add the necessary dependencies into pom.xml file
2) Create JSON web keyset provider 
    jsonwebjoken
3) Create JWT authentication filter
     
4) Create configuratin class for spring security
5) Create a JPA entity for the user
6) Create a JPA repository for the user
7) Create a DTO for the user
8) Create a Service for the user
9) Create a controller for the user

<!-- JDBC -->
-> JDBC is a Java API that allows Java Applications to connect to relational databases (like MySQL, PostgreSQL, etc.)
-> It provides for interface for interacting with a database
-> With JDBC, you can execute SQL Queries, retrieve results, and handle errors
-> Requires to write a boilerplate code by developers which is hectic
-> It doesnot provide features like handling HTTP requests or creating REST API'S. But, you can use JDBC within a Java Application that interacts with databases while using 

    Main Features
    -------------
    1) Direct Database intergration
    2) Requires writing sql queries manually
    3) Handles connection management (but you need to manage it yourself)
    4) No built-in abstraction, meaning you work with SQL direclty in your application

<!-- Annotated Classes -->
SpringBoot is dependency injection framework
A class annotation in Java is a special marker placed above a class to give extra information to a framework like SpringBoot
-- Hey spring boot! Handle this class in a special way

In spring boot when you annotate a class with @Component, @Service, @Repository etc you are telling Spring:
    -> Hey Spring!! Please manage this class for me, create its object, keep it ready, and inject it whenever it's needed

When we use it there is no need to create an object
    -> Spring Already created that object for you behind the scenes when it saw you annotation like @Component. So you don't need to create an object


<!-- When user creates account how can we store into data base -->
<!-- The below are the development steps to intergrate the USERs api with the fronend application -->
DEVELOPMENT STEPS
1) Create context to store the state globally
2) Create a component UserSyncHandler
3) Update the app component


<!-- CONFIGURE CLERK WEBHOOK -->
DEVELOPMENT STEPS
-----------------
1) Create a web hook controller
2) Update the user service
3) Update the security config
4) Update the JWT authentic

NGROK
-----
1) used to trasfer public web url to the local host url


<!-- LOAD THE USER CREDITS -->
DEVELOPMENT CREDITS
-------------------
1) Create a new API endPoint in User controller
2) Update the AppContext to update the state
3) Update the UserSyncHandler component
4) Update the Menubar component to update the credits


<!-- CLIPDROP API CREDITS -->
DEVELOPMENT STEPS
-----------------
1) Create a new account in Clipdrop API and get the API key
2) Update pom.xml to add the dependencies to call the ClipDrop API
3) Create clipdrop client using FeignClient
4) Create a controller to expose the API the endpoint to remove the the image background
5) Create a new component to display and download the image after background is removed
6) Update AppContext to call the backend API and update the state
7) Update the Header Component to remove the image background
8) Update the TryNow component to remove the image background
9) Test the changes inside the browser


<!-- RAZORPAY DEVELOPMENT STEPS -->
DEVELOPMENT STEPS
-----------------
1) Add the razorpay dependency into pom.xml
2) Add the razorpay key id and secret key into application properties file
3) Create JPA entity to store order details
4) Create JPA repository for order entity
5) Create DTO object to map the razorpay order details
6) Create order service to store the order details into database
7) Create order controller to expose the API endpoints

<!-- RAZORPAY PAYMENT INTEGRATION -->
DEVELOPMENT STEPS
-----------------
1) Update the .env file to add the razorpay key id
2) Create order service and consume the Order API
3) Update the pricing component to call the service method
4) Attach the onClick event for the button to buy the credits
