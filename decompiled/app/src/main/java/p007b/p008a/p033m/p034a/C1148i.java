package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelCall;

/* compiled from: lambda */
/* renamed from: b.a.m.a.i */
/* loaded from: classes.dex */
public final /* synthetic */ class C1148i implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1528a;

    public /* synthetic */ C1148i(Model.JsonReader jsonReader) {
        this.f1528a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.f1528a;
        int i = ModelCall.f18564j;
        return Long.valueOf(jsonReader.nextLong(1L));
    }
}
