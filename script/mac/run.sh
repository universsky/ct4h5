cd ${PWD}
./buildApk.sh
./installApk.sh ~/tbsearch_android.sword.signed.apk
./installApk.sh ~/tbsearch_android.sword.test.apk
cd ../
mvn test
