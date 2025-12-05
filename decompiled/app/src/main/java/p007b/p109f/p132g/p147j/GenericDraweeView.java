package p007b.p109f.p132g.p147j;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p132g.p143f.GenericDraweeHierarchyBuilder;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: GenericDraweeView.java */
/* renamed from: b.f.g.j.a, reason: use source file name */
/* loaded from: classes.dex */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }

    public void inflateHierarchy(Context context, AttributeSet attributeSet) {
        FrescoSystrace.m1527b();
        FrescoSystrace.m1527b();
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        AnimatableValueParser.m542l2(genericDraweeHierarchyBuilder, context, attributeSet);
        FrescoSystrace.m1527b();
        setAspectRatio(genericDraweeHierarchyBuilder.f3455e);
        setHierarchy(genericDraweeHierarchyBuilder.m1122a());
        FrescoSystrace.m1527b();
    }

    public GenericDraweeView(Context context) {
        super(context);
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateHierarchy(context, attributeSet);
    }

    @TargetApi(21)
    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        inflateHierarchy(context, attributeSet);
    }
}
