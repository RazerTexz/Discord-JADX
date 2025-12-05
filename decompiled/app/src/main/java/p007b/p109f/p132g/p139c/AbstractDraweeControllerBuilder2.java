package p007b.p109f.p132g.p139c;

import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Objects2;

/* JADX INFO: Add missing generic type declarations: [IMAGE] */
/* compiled from: AbstractDraweeControllerBuilder.java */
/* renamed from: b.f.g.c.b, reason: use source file name */
/* loaded from: classes.dex */
public class AbstractDraweeControllerBuilder2<IMAGE> implements Supplier<DataSource<IMAGE>> {

    /* renamed from: a */
    public final /* synthetic */ DraweeController f3292a;

    /* renamed from: b */
    public final /* synthetic */ String f3293b;

    /* renamed from: c */
    public final /* synthetic */ Object f3294c;

    /* renamed from: d */
    public final /* synthetic */ Object f3295d;

    /* renamed from: e */
    public final /* synthetic */ AbstractDraweeControllerBuilder.EnumC10643b f3296e;

    /* renamed from: f */
    public final /* synthetic */ AbstractDraweeControllerBuilder f3297f;

    public AbstractDraweeControllerBuilder2(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, DraweeController draweeController, String str, Object obj, Object obj2, AbstractDraweeControllerBuilder.EnumC10643b enumC10643b) {
        this.f3297f = abstractDraweeControllerBuilder;
        this.f3292a = draweeController;
        this.f3293b = str;
        this.f3294c = obj;
        this.f3295d = obj2;
        this.f3296e = enumC10643b;
    }

    @Override // com.facebook.common.internal.Supplier
    public Object get() {
        return this.f3297f.mo1056b(this.f3292a, this.f3293b, this.f3294c, this.f3295d, this.f3296e);
    }

    public String toString() {
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m971c("request", this.f3294c.toString());
        return objects2M526h2.toString();
    }
}
