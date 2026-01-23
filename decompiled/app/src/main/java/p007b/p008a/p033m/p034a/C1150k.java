package p007b.p008a.p033m.p034a;

import com.discord.models.domain.Model;
import com.discord.models.domain.ModelNotificationSettings;

/* JADX INFO: renamed from: b.a.m.a.k */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1150k implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1530a;

    public /* synthetic */ C1150k(Model.JsonReader jsonReader) {
        this.f1530a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.f1530a;
        int i = ModelNotificationSettings.FREQUENCY_ALL;
        return (ModelNotificationSettings.ChannelOverride) jsonReader.parse(new ModelNotificationSettings.ChannelOverride());
    }
}
