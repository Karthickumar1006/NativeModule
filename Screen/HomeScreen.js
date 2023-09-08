import React, { useState } from 'react'
import { View, Text, Button, TextInput, NativeModules, DeviceEventEmitter, NativeEventEmitter } from 'react-native'

const HomeScreen = () => {
    const [textInput, setTextInput] = useState("This is my world");
    //Creating native module in the ReactNative
    const { RN } = NativeModules;
    //Creating NewEmitter in the ReactNative to get the value form native 
    const newEmitter = new NativeEventEmitter(RN)
    const onNativeClick = () => {

        //which is used to call the Native module method
        Platform.OS === 'android' && NativeModules.RN.sampleTesting(textInput);

        //here we can get the value which is passed from native
        newEmitter.addListener('EventName', (EventName) => {
            console.log("EventNameEventNameEventName", EventName);
        })
    }

    return (
        <View>
            <TextInput
                placeholder='Text'
                value={textInput}>

            </TextInput>
            <Button onPress={() => {
                onNativeClick()
            }} title='ClickMe'>

            </Button>
        </View>
    )

}

export default HomeScreen;