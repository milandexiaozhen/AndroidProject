LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := HelloJni
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	E:\andriod poject\AdnroidProject\app\src\main\jni\Android.mk \
	E:\andriod poject\AdnroidProject\app\src\main\jni\main.cpp \

LOCAL_C_INCLUDES += E:\andriod poject\AdnroidProject\app\src\main\jni
LOCAL_C_INCLUDES += E:\andriod poject\AdnroidProject\app\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
