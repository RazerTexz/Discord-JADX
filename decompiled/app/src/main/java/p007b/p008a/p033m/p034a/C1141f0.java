package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;

/* JADX INFO: renamed from: b.a.m.a.f0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1141f0 implements Model.JsonReader.KeySelector {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C1141f0 f1521a = new C1141f0();

    @Override // com.discord.models.domain.Model.JsonReader.KeySelector
    public final Object get(Object obj) {
        return Long.valueOf(((UserExperimentDto) obj).getNameHash());
    }
}
