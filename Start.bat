mvn test
rem start cmd
rem adb -s 4d004077b4369049 install -r android-server.apk
rem adb -s 4d004077b4369049 shell am start -a android.intent.action.MAIN -n org.openqa.selenium.android.app/.MainActivity -e debug true
rem adb -s 4d004077b4369049 shell am kill -a android.intent.action.MAIN -n org.openqa.selenium.android.app/.MainActivity -e debug true
rem adb -s 4d004077b4369049 forward tcp:8080 tcp:8080
  