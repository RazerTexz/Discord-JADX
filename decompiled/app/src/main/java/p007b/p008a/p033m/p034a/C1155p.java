package p007b.p008a.p033m.p034a;

import com.discord.api.presence.Presence;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.p */
/* loaded from: classes.dex */
public final /* synthetic */ class C1155p implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1535a;

    public /* synthetic */ C1155p(Model.JsonReader jsonReader) {
        this.f1535a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Presence) InboundGatewayGsonParser.fromJson(this.f1535a, Presence.class);
    }
}
