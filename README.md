This repository is used to send otp on email, that can be used to verify email manually for firebase authentication.
Dependencies used->

In build.gradle(Module:app)-
dependencies{
    implementation 'com.google.android.material:material:1.8.0'
    implementation 'com.github.1902shubh:SendMail:1.0.0'
}

In settings.gradle-
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

I hope it would have helped you


https://youtu.be/Jdn1UBR54m4



