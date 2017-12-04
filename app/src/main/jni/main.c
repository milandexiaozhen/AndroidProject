#include "ndkutils_JniUtils.h"
JNIEXPORT jstring JNICALL Java_ndkutils_JniUtils_getStringFromNative
        (JNIEnv * env, jclass obj){
    return env->NewStringUTF("这里是代码");
}