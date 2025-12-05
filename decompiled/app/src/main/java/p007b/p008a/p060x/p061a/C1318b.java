package p007b.p008a.p060x.p061a;

import com.discord.models.domain.Model;
import com.discord.utilities.error.Error;

/* compiled from: lambda */
/* renamed from: b.a.x.a.b */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1318b implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f2005a;

    public /* synthetic */ C1318b(Model.JsonReader jsonReader) {
        this.f2005a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (Error.SkemaErrorItem) this.f2005a.parse(new Error.SkemaErrorItem(null));
    }
}
