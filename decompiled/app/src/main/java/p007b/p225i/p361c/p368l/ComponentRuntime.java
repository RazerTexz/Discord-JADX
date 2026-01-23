package p007b.p225i.p361c.p368l;

import p007b.p225i.p361c.p400t.Provider2;

/* JADX INFO: renamed from: b.i.c.l.h, reason: use source file name */
/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ComponentRuntime implements Provider2 {

    /* JADX INFO: renamed from: a */
    public final ComponentRuntime4 f12187a;

    /* JADX INFO: renamed from: b */
    public final Component4 f12188b;

    public ComponentRuntime(ComponentRuntime4 componentRuntime4, Component4 component4) {
        this.f12187a = componentRuntime4;
        this.f12188b = component4;
    }

    @Override // p007b.p225i.p361c.p400t.Provider2
    public Object get() {
        ComponentRuntime4 componentRuntime4 = this.f12187a;
        Component4 component4 = this.f12188b;
        int i = ComponentRuntime4.f12191a;
        return component4.f12179e.mo6341a(new RestrictedComponentContainer(component4, componentRuntime4));
    }
}
