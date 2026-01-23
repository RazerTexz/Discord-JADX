package p007b.p225i.p361c.p407x;

import java.util.Set;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentFactory;

/* JADX INFO: renamed from: b.i.c.x.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultUserAgentPublisher.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DefaultUserAgentPublisher implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public static final DefaultUserAgentPublisher f13081a = new DefaultUserAgentPublisher();

    @Override // p007b.p225i.p361c.p368l.ComponentFactory
    /* JADX INFO: renamed from: a */
    public Object mo6341a(ComponentContainer componentContainer) {
        Set setMo6347d = componentContainer.mo6347d(LibraryVersion.class);
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.f13084a;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.f13084a;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    GlobalLibraryVersionRegistrar.f13084a = globalLibraryVersionRegistrar;
                }
            }
        }
        return new DefaultUserAgentPublisher2(setMo6347d, globalLibraryVersionRegistrar);
    }
}
