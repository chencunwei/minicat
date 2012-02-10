/*
 * Copyright 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fanfou.app.hd.ui.actionbarcompat;

import com.fanfou.app.hd.R;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * An abstract class that handles some common action bar-related functionality
 * in the app. This class provides functionality useful for both phones and
 * tablets, and does not require any Android 3.0-specific features, although it
 * uses them if available. Two implementations of this class are
 * {@link ActionBarHelperBase} for a pre-Honeycomb version of the action bar,
 * and {@link ActionBarHelperHoneycomb}, which uses the built-in ActionBar
 * features in Android 3.0 and later.
 */
/**
 * @author mcxiaoke
 * @version 1.0 2012.02.10
 * 
 */
public abstract class ActionBarHelper {
	protected Activity mActivity;

	/**
	 * Factory method for creating {@link ActionBarHelper} objects for a given
	 * activity. Depending on which device the app is running, either a basic
	 * helper or Honeycomb-specific helper will be returned.
	 */
	public static ActionBarHelper createInstance(Activity activity) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return new ActionBarHelperICS(activity);
		} else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			return new ActionBarHelperHoneycomb(activity);
		} else {
			return new ActionBarHelperBase(activity);
		}
	}

	public ActionBarHelper(Activity activity) {
		mActivity = activity;
	}

	/**
	 * Action bar helper code to be run in
	 * {@link Activity#onCreate(android.os.Bundle)}.
	 */
	public void onCreate(Bundle savedInstanceState) {
	}

	/**
	 * Action bar helper code to be run in
	 * {@link Activity#onPostCreate(android.os.Bundle)}.
	 */
	public void onPostCreate(Bundle savedInstanceState) {
	}

	/**
	 * Action bar helper code to be run in
	 * {@link Activity#onTitleChanged(CharSequence, int)}.
	 */
	public void onTitleChanged(CharSequence title, int color) {
	}

	public MenuInflater getMenuInflater(MenuInflater superMenuInflater) {
		return superMenuInflater;
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	/**
	 * Sets the indeterminate loading state of the item with ID
	 * {@link R.id.menu_refresh}. (where the item ID was menu_refresh).
	 */
	public abstract void setRefreshActionItemState(boolean refreshing);

}