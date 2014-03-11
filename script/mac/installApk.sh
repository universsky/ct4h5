for device in $(adb devices | ggrep -v -P 'List|^$' | awk '{print $1}') 
do
    adb install -r $1
done
