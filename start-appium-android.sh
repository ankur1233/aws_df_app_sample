#!/bin/bash

function die {
    echo $1
    exit 1
}

pkg_root_dir=`find $PWD | grep "/Config$" | head -n 1 | xargs dirname`
app_filename="$pkg_root_dir/app/app.apk"
ls -1 $app_filename || die "Did not find app in $pkg_root_dir"

appium --pre-launch --app-pkg com.instagram.android  --app-activity .activity.MainTabActivity --platform-name Android --app $app_filename

"C:\Program Files (x86)\Appium\node.exe" "C:\Program Files (x86)\Appium\node_modules\appium\lib\server\main.js" --address 127.0.0.1 --port 4723 --app "C:\Users\Shoaib Mal\git\aws_cop_app\Instagram.apk" --app-activity .activity.MainTabActivity  --app-pkg com.instagram.android  --platform-name Android --platform-version 23 --automation-name Appium --log-no-color