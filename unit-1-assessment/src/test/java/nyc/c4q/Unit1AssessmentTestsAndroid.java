package nyc.c4q;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.util.ActivityController;

import java.util.Random;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Unit1AssessmentTestsAndroid {

    @Test
    public void test01FixInitialActivityLayout() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).setup().get();
        LinearLayout layout = (LinearLayout) activity.findViewById(R.id.activity_initial);

        assertTrue("LinearLayout(@+id/activity_initial)[0] should be a LinearLayout", layout.getChildAt(0) instanceof LinearLayout);
        LinearLayout counterLayout = (LinearLayout) layout.getChildAt(0);
        assertTrue("LinearLayout(@+id/activity_initial)[0] should have R.id.counterLayout", Helpers.getResourceId(counterLayout).equals("counterLayout"));
        assertTrue("LinearLayout(@+id/activity_initial)[0] should be equal to LinearLayout(@+id/counterLayout)", counterLayout == Helpers.findViewByIdString(activity, "counterLayout"));
        assertTrue("LinearLayout(@+id/activity_initial)[0] should have a horizontal orientation", counterLayout.getOrientation() == LinearLayout.HORIZONTAL);

        assertTrue("LinearLayout(@+id/counterLayout)[0] should be a LinearLayout", counterLayout.getChildAt(0) instanceof LinearLayout);
        LinearLayout counterButtonsLayout = (LinearLayout) counterLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/counterLayout)[0] should have R.id.counterButtonsLayout", Helpers.getResourceId(counterButtonsLayout).equals("counterButtonsLayout"));
        assertTrue("LinearLayout(@+id/counterLayout)[0] should be equal to LinearLayout(@+id/counterButtonsLayout)", counterButtonsLayout == Helpers.findViewByIdString(activity, "counterButtonsLayout"));
        assertTrue("LinearLayout(@+id/counterLayout)[0] should have a vertical orientation", counterButtonsLayout.getOrientation() == LinearLayout.VERTICAL);

        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should be a Button", counterButtonsLayout.getChildAt(0) instanceof Button);
        Button buttonPlus = (Button) counterButtonsLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should have R.id.buttonPlus", Helpers.getResourceId(buttonPlus).equals("buttonPlus"));
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[0] should be equal to Button(@+id/buttonPlus)", buttonPlus == Helpers.findViewByIdString(activity, "buttonPlus"));
        assertEquals("+", buttonPlus.getText());

        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should be a Button", counterButtonsLayout.getChildAt(1) instanceof Button);
        Button buttonMinus = (Button) counterButtonsLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should have R.id.buttonMinus", Helpers.getResourceId(buttonMinus).equals("buttonMinus"));
        assertTrue("LinearLayout(@+id/counterButtonsLayout)[1] should be equal to Button(@+id/buttonMinus)", buttonMinus == Helpers.findViewByIdString(activity, "buttonMinus"));
        assertEquals("-", buttonMinus.getText());

        View tvCounter = counterLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_initial)[0][1] should be equal to TextView(@+id/tvCounter)",
                tvCounter instanceof TextView && Helpers.getResourceId(tvCounter).equals("tvCounter"));
        assertEquals("0", ((TextView) tvCounter).getText());

        View buttonTileActivity = layout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_initial)[1] should be equal to Button(@+id/buttonTileActivity)",
                buttonTileActivity instanceof Button && Helpers.getResourceId(buttonTileActivity).equals("buttonTileActivity"));
        assertEquals("TileActivity", ((Button) buttonTileActivity).getText());

        View buttonEmpty = layout.getChildAt(2);
        assertTrue("LinearLayout(@+id/activity_initial)[2] should be equal to Button(@+id/buttonEmpty)",
                buttonEmpty instanceof Button && Helpers.getResourceId(buttonEmpty).equals("buttonEmpty"));
        assertEquals("Empty", ((Button) buttonEmpty).getText());

        assertEquals("LinearLayout(@+id/counterLayout) should have layout_weight='2'", 2, ((LinearLayout.LayoutParams) counterLayout.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonTileActivity) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonTileActivity.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonEmpty) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonEmpty.getLayoutParams()).weight, 0.01);
        assertEquals("LinearLayout(@+id/counterButtonsLayout) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) counterButtonsLayout.getLayoutParams()).weight, 0.01);
        assertEquals("TextView    (@+id/tvCounter) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) tvCounter.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonPlus) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonPlus.getLayoutParams()).weight, 0.01);
        assertEquals("Button      (@+id/buttonMinus) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) buttonMinus.getLayoutParams()).weight, 0.01);


        assertEquals("LinearLayout(@+id/counterLayout) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) counterLayout.getLayoutParams()).height);
        assertEquals("Button      (@+id/buttonTileActivity) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonTileActivity.getLayoutParams()).height);
        assertEquals("Button      (@+i/buttonEmpty) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonEmpty.getLayoutParams()).height);
        assertEquals("LinearLayout(@+id/counterButtonsLayout) should have layout_width='0dp'", 0, ((LinearLayout.LayoutParams) counterButtonsLayout.getLayoutParams()).width);
        assertEquals("TextView    (@+id/tvCounter) should have layout_width='0dp'", 0, ((LinearLayout.LayoutParams) tvCounter.getLayoutParams()).width);
        assertEquals("Button      (@+id/buttonPlus) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonPlus.getLayoutParams()).height);
        assertEquals("Button      (@+id/buttonMinus) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) buttonMinus.getLayoutParams()).height);

    }

    @Test
    public void test02ButtonPlusShouldIncreaseTvCounter() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).setup().get();
        Button buttonPlus = (Button) Helpers.findViewByIdString(activity, "buttonPlus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonPlus) should not be null", buttonPlus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        for (int i=1; i<10; i++){
            buttonPlus.callOnClick();
            assertEquals(i, Integer.parseInt((String) tvCounter.getText()));
        }
    }

    @Test
    public void test03ButtonMinusShouldDecreaseTvCounter() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).setup().get();
        Button buttonMinus = (Button) Helpers.findViewByIdString(activity, "buttonMinus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonMinus) should not be null", buttonMinus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        for (int i=-1; i>-10; i--){
            buttonMinus.callOnClick();
            assertEquals(i, Integer.parseInt((String) tvCounter.getText()));
        }
    }

    @Test
    public void test04ButtonPlusAndButtonMinusShouldWork() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).setup().get();
        Button buttonPlus = (Button) Helpers.findViewByIdString(activity, "buttonPlus");
        Button buttonMinus = (Button) Helpers.findViewByIdString(activity, "buttonMinus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonPlus) should not be null", buttonPlus);
        assertNotNull("TextView(@+id/buttonMinus) should not be null", buttonMinus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        Random r = new Random(3680);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        int internalCount = 0;
        for (int i=0; i<10000; i++){
            if (r.nextBoolean()){
                internalCount++;
                buttonPlus.callOnClick();
            }
            else {
                internalCount--;
                buttonMinus.callOnClick();
            }
            assertEquals(internalCount, Integer.parseInt((String) tvCounter.getText()));
        }
    }

    @Test
    public void test05TvCounterStateShouldBeSavedThroughActivityLifeCycle(){
        // use InitialActivity.saveState() and InitialActivity.loadState() methods
        ActivityController<InitialActivity> controller = Robolectric.buildActivity(InitialActivity.class).setup();
        InitialActivity activity = controller.get();
        Button buttonPlus = (Button) Helpers.findViewByIdString(activity, "buttonPlus");
        Button buttonMinus = (Button) Helpers.findViewByIdString(activity, "buttonMinus");
        TextView tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertNotNull("TextView(@+id/buttonPlus) should not be null", buttonPlus);
        assertNotNull("TextView(@+id/buttonMinus) should not be null", buttonMinus);
        assertNotNull("TextView(@+id/tvCounter) should not be null", tvCounter);

        assertEquals(0, Integer.parseInt((String) tvCounter.getText()));
        buttonPlus.callOnClick();
        assertEquals(1, Integer.parseInt((String) tvCounter.getText()));
        buttonPlus.callOnClick();
        assertEquals(2, Integer.parseInt((String) tvCounter.getText()));
        buttonMinus.callOnClick();
        assertEquals(1, Integer.parseInt((String) tvCounter.getText()));

        controller.pause().stop().destroy();
        controller = Robolectric.buildActivity(InitialActivity.class).setup();
        activity = controller.get();
        tvCounter = (TextView) Helpers.findViewByIdString(activity, "tvCounter");

        assertEquals(1, Integer.parseInt((String) tvCounter.getText()));

    }

    @Test
    public void test06ClickButtonToStartIntentForTileActivity() throws Exception {
        InitialActivity activity = Robolectric.buildActivity(InitialActivity.class).setup().get();
        Button buttonTileActivity = (Button) Helpers.findViewByIdString(activity, "buttonTileActivity");
        assertNotNull("Button(@+id/buttonTileActivity) should not be null", buttonTileActivity);
        buttonTileActivity.callOnClick();

        ShadowApplication sa = Robolectric.shadowOf(activity.getApplication());
        Intent nextStartedActivity = sa.getNextStartedActivity();

        assertNotNull("Intent(nyc.c4q/nyc.c4q.TileActivity) is not queued up", nextStartedActivity);
        assertEquals("nyc.c4q/nyc.c4q.TileActivity", nextStartedActivity.getComponent().flattenToString());
    }

    @Test
    public void test07FixTileActivityLayout() throws Exception {
        TileActivity ta = Robolectric.buildActivity(TileActivity.class).setup().get();
        LinearLayout taLayout = (LinearLayout) ta.findViewById(R.id.activity_tile);

        assertTrue("LinearLayout(@+id/activity_tile) should have a horizontal orientation",
                taLayout.getOrientation() == LinearLayout.HORIZONTAL);

        assertTrue("LinearLayout(@+id/activity_tile)[0] should be a LinearLayout", taLayout.getChildAt(0) instanceof LinearLayout);
        LinearLayout leftSide = (LinearLayout) taLayout.getChildAt(0);
        assertTrue("LinearLayout(@+id/activity_tile)[0] should have R.id.leftSide", Helpers.getResourceId(leftSide).equals("leftSide"));
        assertTrue("LinearLayout(@+id/activity_tile)[0] should be equal to LinearLayout(@+id/leftSide)", leftSide == Helpers.findViewByIdString(ta, "leftSide"));
        assertTrue("LinearLayout(@+id/activity_tile)[0] should have a vertical orientation",
                leftSide.getOrientation() == LinearLayout.VERTICAL);
        assertEquals("View(@+id/leftSide) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) leftSide.getLayoutParams()).weight, 0.01);

        assertTrue("LinearLayout(@+id/activity_tile)[1] should be a LinearLayout", taLayout.getChildAt(1) instanceof LinearLayout);
        LinearLayout rightSide = (LinearLayout) taLayout.getChildAt(1);
        assertTrue("LinearLayout(@+id/activity_tile)[1] should have R.id.rightSide", Helpers.getResourceId(rightSide).equals("rightSide"));
        assertTrue("LinearLayout(@+id/activity_tile)[1] should be equal to LinearLayout(@+id/rightSide)", rightSide == Helpers.findViewByIdString(ta, "rightSide"));
        assertTrue("LinearLayout(@+id/activity_tile)[1] should have a vertical orientation",
                rightSide.getOrientation() == LinearLayout.VERTICAL);
        assertEquals("View(@+id/rightSide) should have layout_weight='1'", 1, ((LinearLayout.LayoutParams) rightSide.getLayoutParams()).weight, 0.01);


        View redView  = leftSide.getChildAt(0);
        assertTrue("LinearLayout(@+id/leftSide)[0] should have R.id.redView", Helpers.getResourceId(redView).equals("redView"));
        assertTrue("LinearLayout(@+id/leftSide)[0] should be equal to View(@+id/redView)", redView == Helpers.findViewByIdString(ta, "redView"));
        Drawable redViewBackground = redView.getBackground();
        assertThat(redViewBackground, instanceOf(ColorDrawable.class));
        assertEquals(0xffff0000, ((ColorDrawable) redViewBackground).getColor());

        View greenView  = leftSide.getChildAt(1);
        assertTrue("LinearLayout(@+id/leftSide)[1] should have R.id.greenView", Helpers.getResourceId(greenView).equals("greenView"));
        assertTrue("LinearLayout(@+id/leftSide)[1] should be equal to View(@+id/greenView)", greenView == Helpers.findViewByIdString(ta, "greenView"));
        Drawable greenViewBackground = greenView.getBackground();
        assertThat(greenViewBackground, instanceOf(ColorDrawable.class));
        assertEquals(0xff00ff00, ((ColorDrawable) greenViewBackground).getColor());

        View yellowView  = rightSide.getChildAt(0);
        assertTrue("LinearLayout(@+id/rightSide)[0] should have R.id.yellowView", Helpers.getResourceId(yellowView).equals("yellowView"));
        assertTrue("LinearLayout(@+id/rightSide)[0] should be equal to View(@+id/yellowView)", yellowView == Helpers.findViewByIdString(ta, "yellowView"));
        Drawable yellowViewBackground = yellowView.getBackground();
        assertThat(yellowViewBackground, instanceOf(ColorDrawable.class));
        assertEquals(0xffffff00, ((ColorDrawable) yellowViewBackground).getColor());

        View whiteView  = rightSide.getChildAt(1);
        assertTrue("LinearLayout(@+id/rightSide)[1] should have R.id.whiteView", Helpers.getResourceId(whiteView).equals("whiteView"));
        assertTrue("LinearLayout(@+id/rightSide)[1] should be equal to View(@+id/whiteView)", whiteView == Helpers.findViewByIdString(ta, "whiteView"));
        Drawable whiteViewBackground = whiteView.getBackground();
        assertThat(whiteViewBackground, instanceOf(ColorDrawable.class));
        assertEquals(0xffffffff, ((ColorDrawable) whiteViewBackground).getColor());

        View blueView  = rightSide.getChildAt(2);
        assertTrue("LinearLayout(@+id/rightSide)[2] should have R.id.blueView", Helpers.getResourceId(blueView).equals("blueView"));
        assertTrue("LinearLayout(@+id/rightSide)[2] should be equal to View(@+id/blueView)", blueView == Helpers.findViewByIdString(ta, "blueView"));
        Drawable blueViewBackground = blueView.getBackground();
        assertThat(blueViewBackground, instanceOf(ColorDrawable.class));
        assertEquals(0xff0000ff, ((ColorDrawable) blueViewBackground).getColor());

        assertEquals("View(@+id/redView) should have layout_weight='40'", 40, ((LinearLayout.LayoutParams) redView.getLayoutParams()).weight, 0.01);
        assertEquals("View(@+id/greenView) should have layout_weight='60'", 60, ((LinearLayout.LayoutParams) greenView.getLayoutParams()).weight, 0.01);
        assertEquals("View(@+id/yellowView) should have layout_weight='33'", 33, ((LinearLayout.LayoutParams) yellowView.getLayoutParams()).weight, 0.01);
        assertEquals("View(@+id/whiteView) should have layout_weight='44'", 44, ((LinearLayout.LayoutParams) whiteView.getLayoutParams()).weight, 0.01);
        assertEquals("View(@+id/blueView) should have layout_weight='22'", 22, ((LinearLayout.LayoutParams) blueView.getLayoutParams()).weight, 0.01);

        assertEquals("View(@+id/redView) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) redView.getLayoutParams()).height);
        assertEquals("View(@+id/greenView) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) greenView.getLayoutParams()).height);
        assertEquals("View(@+id/yellowView) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) yellowView.getLayoutParams()).height);
        assertEquals("View(@+id/whiteView) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) whiteView.getLayoutParams()).height);
        assertEquals("View(@+id/blueView) should have layout_height='0dp'", 0, ((LinearLayout.LayoutParams) blueView.getLayoutParams()).height);

    }
}
