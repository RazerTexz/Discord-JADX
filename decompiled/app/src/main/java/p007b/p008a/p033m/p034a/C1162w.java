package p007b.p008a.p033m.p034a;

import com.discord.api.user.User;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;

/* JADX INFO: renamed from: b.a.m.a.w */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1162w implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1543a;

    public /* synthetic */ C1162w(Model.JsonReader jsonReader) {
        this.f1543a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (User) InboundGatewayGsonParser.fromJson(this.f1543a, User.class);
    }
}
