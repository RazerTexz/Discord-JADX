package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;

/* JADX INFO: renamed from: b.a.m.a.a0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1131a0 implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1511a;

    public /* synthetic */ C1131a0(Model.JsonReader jsonReader) {
        this.f1511a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return UserExperimentDto.Parser.parse(this.f1511a);
    }
}
