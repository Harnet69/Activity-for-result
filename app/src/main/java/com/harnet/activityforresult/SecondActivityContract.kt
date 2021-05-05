package com.harnet.activityforresult

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.provider.ContactsContract.Intents.Insert.DATA
import androidx.activity.result.contract.ActivityResultContract

//ActivityResultContract<InputType (String), OutputType? (String?)()
class SecondActivityContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        //val bundle = Bundle()
        //bundle.putString(key, input)
        val intent = Intent(context, SecondActivity::class.java)
        //intent.putExtra(key, input)
        //intent.putExtra(bundleKey, bundle)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            // Process the data received from second activity.
            RESULT_OK -> intent?.getStringExtra(DATA)
            else -> null
        }
    }
}