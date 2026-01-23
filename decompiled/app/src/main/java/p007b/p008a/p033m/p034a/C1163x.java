package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelUserRelationship;

/* JADX INFO: renamed from: b.a.m.a.x */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1163x implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1544a;

    public /* synthetic */ C1163x(Model.JsonReader jsonReader) {
        this.f1544a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelUserRelationship) this.f1544a.parse(new ModelUserRelationship());
    }
}
