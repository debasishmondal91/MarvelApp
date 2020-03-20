package com.example.marvelappiness.data;

import com.example.marvelappiness.data.remote.ApiHelper;

/**
 * Created by debasish on 20/03/20.
 */

public interface DataManager extends ApiHelper {

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
