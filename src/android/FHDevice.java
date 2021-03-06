package com.feedhenry.phonegap.device;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FHDevice extends CordovaPlugin {
    public static final String TAG = "FHDevice";
    /**
     * Constructor.
     */
    public FHDevice() {
    }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getFHDeviceInfo")) {
            JSONObject r = new JSONObject();
            r.put("density", this.getDensity());
            callbackContext.success(r);
        }
        else {
            return false;
        }
        return true;
    }

    public float getDensity() {
      return this.cordova.getActivity().getResources().getDisplayMetrics().density;
    }

}