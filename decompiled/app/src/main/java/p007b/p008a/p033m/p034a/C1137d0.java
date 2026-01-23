package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelGuildFolder;

/* JADX INFO: renamed from: b.a.m.a.d0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1137d0 implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1517a;

    public /* synthetic */ C1137d0(Model.JsonReader jsonReader) {
        this.f1517a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return ModelGuildFolder.Parser.INSTANCE.parse(this.f1517a);
    }
}
