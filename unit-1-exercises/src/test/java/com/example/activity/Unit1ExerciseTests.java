package com.example.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Unit1ExerciseTests {

    DeckardActivity mActivity;
    ActivityController<DeckardActivity> mAC;

    @Before
    public void setUp() throws Exception {
        // uncomment the following line to pass test 01
//        mActivity = Robolectric.buildActivity(DeckardActivity.class).create().get();
//        mAC = Robolectric.buildActivity(DeckardActivity.class).create().start();
    }

    @Test
    public void test01ActivityExists() throws Exception {
        assertTrue(mActivity != null);
    }

    @Test
    public void test02AddTextViewToLayout() throws Exception {
        int textViewId = mActivity.getResources().getIdentifier("text", "id", mActivity.getPackageName());
        assertTrue("TextView(@+id/text) not found", textViewId > 0);
    }

    @Test
    public void test03SetTextViewValueToTODO() throws Exception {
        int textViewId = mActivity.getResources().getIdentifier("text", "id", mActivity.getPackageName());
        assertTrue("TextView(@+id/text) not found", textViewId > 0);
        TextView tv = (TextView) mActivity.findViewById(textViewId);
        assertEquals("Help, I'm stuck in an Android Factory!", tv.getText());
    }

    @Test
    public void test04AddImageViewToLayout() throws Exception {
        int imageViewId = mActivity.getResources().getIdentifier("image", "id", mActivity.getPackageName());
        assertTrue("ImageView(@+id/image) not found", imageViewId > 0);
    }

    @Test
    public void test05SetImageViewToHelloGreen() throws Exception {
        int imageViewId = mActivity.getResources().getIdentifier("image", "id", mActivity.getPackageName());
        assertTrue("ImageView(@+id/image) not found", imageViewId > 0);
        ImageView iv = (ImageView) mActivity.findViewById(imageViewId);

        Bitmap bm = ((BitmapDrawable) iv.getDrawable()).getBitmap();

        float deviceDensity = mActivity.getResources().getDisplayMetrics().density;

        assertEquals("actual height value: " + bm.getHeight(), (deviceDensity * 20), (float) bm.getHeight(), 0.01);
        assertEquals("actual width value: " + bm.getWidth(), (deviceDensity * 20), (float) bm.getWidth(), 0.01);

        // TODO enable later using ShadowDrawable or remove
        // http://stackoverflow.com/questions/18008044/assert-imageview-was-loaded-with-specific-drawable-resource-id
        //assertEquals(0xFF00FF00, bm.getPixel(0, 0));
    }

    @Test
    public void test06EditTextActivityExists() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();

        Class klass = classLoader.loadClass("com.example.activity.EditTextActivity");
        Activity editTextActivity = (Activity) Robolectric.buildActivity(klass).create().get();
        assertTrue("EditTextActivity should extend Activity", editTextActivity instanceof Activity);
    }

    @Test
    public void test07EditTextActivityLayoutExists() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class klass = classLoader.loadClass("com.example.activity.EditTextActivity");
        Activity editTextActivity = (Activity) Robolectric.buildActivity(klass).create().get();
        int activity_edit_text_id = editTextActivity.getResources().getIdentifier("activity_edit_text", "layout", editTextActivity.getPackageName());
        assertTrue("R.layout.activity_edit_text not found", activity_edit_text_id > 0);
        int activity_edit_text_layout_id = editTextActivity.getResources().getIdentifier("activity_edit_text_layout", "id", editTextActivity.getPackageName());
        assertTrue("View/Layout(@+id/activity_edit_text_layout) not found", activity_edit_text_layout_id > 0);
        View editTextLayoutView = editTextActivity.findViewById(activity_edit_text_layout_id);
        assertTrue("R.id.activity_edit_text_layout should not be a RelativeLayout", !(editTextLayoutView instanceof RelativeLayout));
        assertTrue("R.id.activity_edit_text_layout should be a LinearLayout", editTextLayoutView instanceof LinearLayout);
        LinearLayout editTextLayout = (LinearLayout) editTextLayoutView;

        View v = editTextLayout.getChildAt(0);

    }

    @Test
    public void test08EditTextActivityTextViewCounterExists() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class klass = classLoader.loadClass("com.example.activity.EditTextActivity");
        Activity editTextActivity = (Activity) Robolectric.buildActivity(klass).create().get();
        int activity_edit_text_layout_id = editTextActivity.getResources().getIdentifier("activity_edit_text_layout", "id", editTextActivity.getPackageName());
        View editTextLayoutView = editTextActivity.findViewById(activity_edit_text_layout_id);
        LinearLayout editTextLayout = (LinearLayout) editTextLayoutView;

        View tvView = editTextLayout.getChildAt(0);
        String tvIDString = editTextActivity.getResources().getResourceEntryName(tvView.getId());
        assertTrue("EditTextActivity->LinearLayout[0] should be a TextView", tvView instanceof TextView);
        assertTrue("EditTextActivity->LinearLayout[0] should have the id (@+id/counter)", tvIDString.equals("counter"));
        TextView tv = (TextView) tvView;
        assertTrue("EditTextActivity->LinearLayout[0] should have initial value '0'", tv.getText().equals("0"));
    }

    @Test
    public void test09EditTextActivityButtonExists() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class klass = classLoader.loadClass("com.example.activity.EditTextActivity");
        Activity editTextActivity = (Activity) Robolectric.buildActivity(klass).create().get();
        int activity_edit_text_layout_id = editTextActivity.getResources().getIdentifier("activity_edit_text_layout", "id", editTextActivity.getPackageName());
        View editTextLayoutView = editTextActivity.findViewById(activity_edit_text_layout_id);
        LinearLayout editTextLayout = (LinearLayout) editTextLayoutView;

        View buttonView = editTextLayout.getChildAt(1);
        String buttonIDString = editTextActivity.getResources().getResourceEntryName(buttonView.getId());
        assertTrue("EditTextActivity->LinearLayout[1] should be a Button", buttonView instanceof Button);
        assertTrue("EditTextActivity->LinearLayout[1] should have the id (@+id/button)", buttonIDString.equals("button"));
        Button button = (Button) buttonView;
        assertTrue("EditTextActivity->LinearLayout[0] should have initial value 'click!'", button.getText().equals("click!"));
    }

    @Test
    public void test10EditTextActivityCounterGoesUpOnButtonClick() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class klass = classLoader.loadClass("com.example.activity.EditTextActivity");
        Activity editTextActivity = (Activity) Robolectric.buildActivity(klass).create().get();
        int activity_edit_text_layout_id = editTextActivity.getResources().getIdentifier("activity_edit_text_layout", "id", editTextActivity.getPackageName());
        View editTextLayoutView = editTextActivity.findViewById(activity_edit_text_layout_id);
        LinearLayout editTextLayout = (LinearLayout) editTextLayoutView;

        TextView tv = (TextView) editTextLayout.getChildAt(0);
        Button button = (Button) editTextLayout.getChildAt(1);

        for (int i=0; i<10; i++){
            assertTrue(String.format("Counter should have value %s", i), tv.getText().equals(String.format("%s",i)));
            button.callOnClick();
        }


    }
}
