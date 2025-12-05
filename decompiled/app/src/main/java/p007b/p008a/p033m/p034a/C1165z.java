package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentDto;

/* compiled from: lambda */
/* renamed from: b.a.m.a.z */
/* loaded from: classes.dex */
public final /* synthetic */ class C1165z implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1546a;

    public /* synthetic */ C1165z(Model.JsonReader jsonReader) {
        this.f1546a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return GuildExperimentDto.Parser.parse(this.f1546a);
    }
}
