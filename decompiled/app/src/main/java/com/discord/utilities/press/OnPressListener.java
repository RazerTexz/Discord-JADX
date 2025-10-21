package com.discord.utilities.press;

import android.view.MotionEvent;
import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OnPressListener.kt */
/* loaded from: classes2.dex */
public final class OnPressListener implements View.OnTouchListener {
    private final OnPress onPress;
    private boolean pressed;

    /* compiled from: OnPressListener.kt */
    /* renamed from: com.discord.utilities.press.OnPressListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnPress {
        public final /* synthetic */ Function1 $onPress;

        public AnonymousClass1(Function1 function1) {
            this.$onPress = function1;
        }

        @Override // com.discord.utilities.press.OnPressListener.OnPress
        public void onPress(boolean pressed) {
            this.$onPress.invoke(Boolean.valueOf(pressed));
        }
    }

    /* compiled from: OnPressListener.kt */
    public interface OnPress {
        void onPress(boolean pressed);
    }

    public OnPressListener(OnPress onPress) {
        Intrinsics3.checkNotNullParameter(onPress, "onPress");
        this.onPress = onPress;
    }

    private final Boolean isPressed(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                if (action != 5) {
                    if (action != 6) {
                        return null;
                    }
                }
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        boolean zBooleanValue;
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(event, "event");
        Boolean boolIsPressed = isPressed(event);
        if (boolIsPressed == null || this.pressed == (zBooleanValue = boolIsPressed.booleanValue())) {
            return false;
        }
        this.pressed = zBooleanValue;
        this.onPress.onPress(zBooleanValue);
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnPressListener(Function1<? super Boolean, Unit> function1) {
        this(new AnonymousClass1(function1));
        Intrinsics3.checkNotNullParameter(function1, "onPress");
    }
}
