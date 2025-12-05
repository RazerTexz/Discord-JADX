package p007b.p225i.p361c.p407x;

import android.content.Context;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentFactory;

/* compiled from: LibraryVersionComponent.java */
/* renamed from: b.i.c.x.f, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class LibraryVersionComponent implements ComponentFactory {

    /* renamed from: a */
    public final String f13086a;

    /* renamed from: b */
    public final LibraryVersionComponent2 f13087b;

    public LibraryVersionComponent(String str, LibraryVersionComponent2 libraryVersionComponent2) {
        this.f13086a = str;
        this.f13087b = libraryVersionComponent2;
    }

    @Override // p007b.p225i.p361c.p368l.ComponentFactory
    /* renamed from: a */
    public Object mo6341a(ComponentContainer componentContainer) {
        return new AutoValue_LibraryVersion(this.f13086a, this.f13087b.mo6336a((Context) componentContainer.mo6346a(Context.class)));
    }
}
