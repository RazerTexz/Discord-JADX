package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import p007b.p225i.p226a.p228b.p229i.CctTransportBackend3;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendFactory;
import p007b.p225i.p226a.p228b.p231j.p232q.CreationContext;
import p007b.p225i.p226a.p228b.p231j.p232q.TransportBackend;

@Keep
/* loaded from: classes3.dex */
public class CctBackendFactory implements BackendFactory {
    @Override // p007b.p225i.p226a.p228b.p231j.p232q.BackendFactory
    public TransportBackend create(CreationContext creationContext) {
        return new CctTransportBackend3(creationContext.mo2366a(), creationContext.mo2369d(), creationContext.mo2368c());
    }
}
