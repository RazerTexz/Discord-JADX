package p007b.p008a.p033m.p034a;

import com.discord.api.user.User;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* compiled from: lambda */
/* renamed from: b.a.m.a.w */
/* loaded from: classes.dex */
public final /* synthetic */ class C1162w implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1543a;

    public /* synthetic */ C1162w(Model.JsonReader jsonReader) {
        this.f1543a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (User) InboundGatewayGsonParser.fromJson(this.f1543a, User.class);
    }
}
