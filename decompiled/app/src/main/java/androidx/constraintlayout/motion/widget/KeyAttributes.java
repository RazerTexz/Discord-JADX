package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.C0201R;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: loaded from: classes.dex */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    public static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private boolean mVisibility = false;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(C0201R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(C0201R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(C0201R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(C0201R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(C0201R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(C0201R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(C0201R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(C0201R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        KeyAttributes.access$002(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$000(keyAttributes)));
                        break;
                    case 2:
                        KeyAttributes.access$102(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$100(keyAttributes)));
                        break;
                    case 3:
                    case 11:
                    default:
                        StringBuilder sbM833U = outline.m833U("unused attribute 0x");
                        sbM833U.append(Integer.toHexString(index));
                        sbM833U.append("   ");
                        sbM833U.append(mAttrMap.get(index));
                        Log.e("KeyAttribute", sbM833U.toString());
                        break;
                    case 4:
                        KeyAttributes.access$202(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$200(keyAttributes)));
                        break;
                    case 5:
                        KeyAttributes.access$502(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$500(keyAttributes)));
                        break;
                    case 6:
                        KeyAttributes.access$602(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$600(keyAttributes)));
                        break;
                    case 7:
                        KeyAttributes.access$402(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$400(keyAttributes)));
                        break;
                    case 8:
                        KeyAttributes.access$1102(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1100(keyAttributes)));
                        break;
                    case 9:
                        KeyAttributes.access$902(keyAttributes, typedArray.getString(index));
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                            keyAttributes.mTargetId = resourceId;
                            if (resourceId == -1) {
                                keyAttributes.mTargetString = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyAttributes.mTargetString = typedArray.getString(index);
                        } else {
                            keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                        }
                        break;
                    case 12:
                        keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                        break;
                    case 13:
                        KeyAttributes.access$302(keyAttributes, typedArray.getInteger(index, KeyAttributes.access$300(keyAttributes)));
                        break;
                    case 14:
                        KeyAttributes.access$1002(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1000(keyAttributes)));
                        break;
                    case 15:
                        KeyAttributes.access$1202(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1200(keyAttributes)));
                        break;
                    case 16:
                        KeyAttributes.access$1302(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1300(keyAttributes)));
                        break;
                    case 17:
                        KeyAttributes.access$1402(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1400(keyAttributes)));
                        break;
                    case 18:
                        KeyAttributes.access$1502(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1500(keyAttributes)));
                        break;
                    case 19:
                        KeyAttributes.access$702(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$700(keyAttributes)));
                        break;
                    case 20:
                        KeyAttributes.access$802(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$800(keyAttributes)));
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    public static /* synthetic */ float access$000(KeyAttributes keyAttributes) {
        return keyAttributes.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyAttributes keyAttributes, float f) {
        keyAttributes.mAlpha = f;
        return f;
    }

    public static /* synthetic */ float access$100(KeyAttributes keyAttributes) {
        return keyAttributes.mElevation;
    }

    public static /* synthetic */ float access$1000(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleY;
    }

    public static /* synthetic */ float access$1002(KeyAttributes keyAttributes, float f) {
        keyAttributes.mScaleY = f;
        return f;
    }

    public static /* synthetic */ float access$102(KeyAttributes keyAttributes, float f) {
        keyAttributes.mElevation = f;
        return f;
    }

    public static /* synthetic */ float access$1100(KeyAttributes keyAttributes) {
        return keyAttributes.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1102(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTransitionPathRotate = f;
        return f;
    }

    public static /* synthetic */ float access$1200(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationX;
    }

    public static /* synthetic */ float access$1202(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationX = f;
        return f;
    }

    public static /* synthetic */ float access$1300(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationY;
    }

    public static /* synthetic */ float access$1302(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationY = f;
        return f;
    }

    public static /* synthetic */ float access$1400(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationZ;
    }

    public static /* synthetic */ float access$1402(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationZ = f;
        return f;
    }

    public static /* synthetic */ float access$1500(KeyAttributes keyAttributes) {
        return keyAttributes.mProgress;
    }

    public static /* synthetic */ float access$1502(KeyAttributes keyAttributes, float f) {
        keyAttributes.mProgress = f;
        return f;
    }

    public static /* synthetic */ float access$200(KeyAttributes keyAttributes) {
        return keyAttributes.mRotation;
    }

    public static /* synthetic */ float access$202(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotation = f;
        return f;
    }

    public static /* synthetic */ int access$300(KeyAttributes keyAttributes) {
        return keyAttributes.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyAttributes keyAttributes, int i) {
        keyAttributes.mCurveFit = i;
        return i;
    }

    public static /* synthetic */ float access$400(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleX;
    }

    public static /* synthetic */ float access$402(KeyAttributes keyAttributes, float f) {
        keyAttributes.mScaleX = f;
        return f;
    }

    public static /* synthetic */ float access$500(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationX;
    }

    public static /* synthetic */ float access$502(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotationX = f;
        return f;
    }

    public static /* synthetic */ float access$600(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationY;
    }

    public static /* synthetic */ float access$602(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotationY = f;
        return f;
    }

    public static /* synthetic */ float access$700(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotX;
    }

    public static /* synthetic */ float access$702(KeyAttributes keyAttributes, float f) {
        keyAttributes.mPivotX = f;
        return f;
    }

    public static /* synthetic */ float access$800(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotY;
    }

    public static /* synthetic */ float access$802(KeyAttributes keyAttributes, float f) {
        keyAttributes.mPivotY = f;
        return f;
    }

    public static /* synthetic */ String access$902(KeyAttributes keyAttributes, String str) {
        keyAttributes.mTransitionEasing = str;
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addValues(HashMap<String, SplineSet> map) {
        for (String str : map.keySet()) {
            SplineSet splineSet = map.get(str);
            if (!str.startsWith(Key.CUSTOM)) {
                switch (str) {
                    case "rotationX":
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mRotationX);
                            break;
                        }
                        break;
                    case "rotationY":
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mRotationY);
                            break;
                        }
                        break;
                    case "translationX":
                        if (Float.isNaN(this.mTranslationX)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                            break;
                        }
                        break;
                    case "translationY":
                        if (Float.isNaN(this.mTranslationY)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                            break;
                        }
                        break;
                    case "translationZ":
                        if (Float.isNaN(this.mTranslationZ)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                            break;
                        }
                        break;
                    case "progress":
                        if (Float.isNaN(this.mProgress)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mProgress);
                            break;
                        }
                        break;
                    case "scaleX":
                        if (Float.isNaN(this.mScaleX)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mScaleX);
                            break;
                        }
                        break;
                    case "scaleY":
                        if (Float.isNaN(this.mScaleY)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mScaleY);
                            break;
                        }
                        break;
                    case "transformPivotX":
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mPivotX);
                            break;
                        }
                        break;
                    case "transformPivotY":
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mPivotY);
                            break;
                        }
                        break;
                    case "rotation":
                        if (Float.isNaN(this.mRotation)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mRotation);
                            break;
                        }
                        break;
                    case "elevation":
                        if (Float.isNaN(this.mElevation)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mElevation);
                            break;
                        }
                        break;
                    case "transitionPathRotate":
                        if (Float.isNaN(this.mTransitionPathRotate)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                            break;
                        }
                        break;
                    case "alpha":
                        if (Float.isNaN(this.mAlpha)) {
                            break;
                        } else {
                            splineSet.setPoint(this.mFramePosition, this.mAlpha);
                            break;
                        }
                        break;
                    default:
                        Log.v("KeyAttributes", "UNKNOWN addValues \"" + str + "\"");
                        break;
                }
            } else {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null) {
                    ((SplineSet.CustomSet) splineSet).setPoint(this.mFramePosition, constraintAttribute);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, C0201R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> map) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            map.put(Key.ALPHA, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            map.put(Key.ELEVATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            map.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            map.put(Key.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            map.put(Key.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            map.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            map.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            map.put(Key.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            map.put(Key.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            map.put(Key.TRANSLATION_Z, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            map.put(Key.TRANSITION_PATH_ROTATE, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            map.put(Key.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            map.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                map.put(outline.m883w("CUSTOM,", it.next()), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "motionProgress":
                this.mProgress = toFloat(obj);
                break;
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "rotationX":
                this.mRotationX = toFloat(obj);
                break;
            case "rotationY":
                this.mRotationY = toFloat(obj);
                break;
            case "translationX":
                this.mTranslationX = toFloat(obj);
                break;
            case "translationY":
                this.mTranslationY = toFloat(obj);
                break;
            case "pivotX":
                this.mPivotX = toFloat(obj);
                break;
            case "pivotY":
                this.mPivotY = toFloat(obj);
                break;
            case "scaleX":
                this.mScaleX = toFloat(obj);
                break;
            case "scaleY":
                this.mScaleY = toFloat(obj);
                break;
            case "rotation":
                this.mRotation = toFloat(obj);
                break;
            case "elevation":
                this.mElevation = toFloat(obj);
                break;
            case "transitionPathRotate":
                this.mTransitionPathRotate = toFloat(obj);
                break;
            case "alpha":
                this.mAlpha = toFloat(obj);
                break;
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "mTranslationZ":
                this.mTranslationZ = toFloat(obj);
                break;
            case "visibility":
                this.mVisibility = toBoolean(obj);
                break;
        }
    }
}
