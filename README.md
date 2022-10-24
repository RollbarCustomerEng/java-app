# java-app
A Java command line application show cases various Rollbar configuration

# Steps to build and execute the application  

## Step 1: 
Open a terminal window and change to the root directory  

## Step 2:  
Download the appropriate gradle wrapper

gradle wrapper --gradle-version 7.1  

## Step 3:  
./gradlew clean build


## Step 4:
Create the 3 expected environment variables
See ./app/src/main/java/rb/java/RollbarConfig.java

export rollbar_access_token=YOUR_POST_SERVER_ITEM_TOKEN
export rollbar_environment=production
export rollbar_version=1.0.0

Notes:
If you use the git commit SHA or git release tag as the value for the rollbar_version environment variable,
you will be able to link directly to the commit in your reposiory from the Rollbar web application

You can create/get a project access token with post_server_item scope at the following URL
https://rollbar.com/ACCOUNT_NAME/PROJECT_NAME/settings/access_tokens/


## Step 5:
Execute the application

./gradlew run


## Step 6
Review app/src/main/java/rb/java/ConfigRollbar.java

See how it references various Provider classes to add additional data to the occurrence payload