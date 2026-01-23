package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.C10638R;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p127l.UriUtil;
import p007b.p109f.p132g.p133a.p134a.PipelineDraweeControllerBuilder;
import p007b.p109f.p132g.p147j.GenericDraweeView;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDraweeView extends GenericDraweeView {
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private AbstractDraweeControllerBuilder mControllerBuilder;

    public SimpleDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        int resourceId;
        try {
            FrescoSystrace.m1527b();
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                AnimatableValueParser.m591y(sDraweecontrollerbuildersupplier, "SimpleDraweeView was not initialized!");
                this.mControllerBuilder = sDraweecontrollerbuildersupplier.get();
            }
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10638R.a.SimpleDraweeView);
                try {
                    int i = C10638R.a.SimpleDraweeView_actualImageUri;
                    if (typedArrayObtainStyledAttributes.hasValue(i)) {
                        setImageURI(Uri.parse(typedArrayObtainStyledAttributes.getString(i)), (Object) null);
                    } else {
                        int i2 = C10638R.a.SimpleDraweeView_actualImageResource;
                        if (typedArrayObtainStyledAttributes.hasValue(i2) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, -1)) != -1) {
                            if (isInEditMode()) {
                                setImageResource(resourceId);
                            } else {
                                setActualImageResource(resourceId);
                            }
                        }
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
            }
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public void setActualImageResource(@DrawableRes int i, Object obj) {
        Uri uri = UriUtil.f3138a;
        setImageURI(new Uri.Builder().scheme("res").path(String.valueOf(i)).build(), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageRequest(ImageRequest imageRequest) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        abstractDraweeControllerBuilder.f19484h = imageRequest;
        abstractDraweeControllerBuilder.f19490n = getController();
        setController(abstractDraweeControllerBuilder.m8667a());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, (Object) null);
    }

    public void setImageURI(String str) {
        setImageURI(str, (Object) null);
    }

    public SimpleDraweeView(Context context) {
        super(context);
        init(context, null);
    }

    public void setImageURI(Uri uri, Object obj) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        abstractDraweeControllerBuilder.f19483g = obj;
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderM1058f = ((PipelineDraweeControllerBuilder) abstractDraweeControllerBuilder).m1058f(uri);
        pipelineDraweeControllerBuilderM1058f.f19490n = getController();
        setController(pipelineDraweeControllerBuilderM1058f.m8667a());
    }

    public void setActualImageResource(@DrawableRes int i) {
        setActualImageResource(i, null);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    public void setImageURI(String str, Object obj) {
        setImageURI(str != null ? Uri.parse(str) : null, obj);
    }
}
