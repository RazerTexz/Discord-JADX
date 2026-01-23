package p007b.p008a.p033m.p034a.p035h0;

import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.ModelEmojiUnicode;

/* JADX INFO: renamed from: b.a.m.a.h0.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1145a implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1525a;

    public /* synthetic */ C1145a(Model.JsonReader jsonReader) {
        this.f1525a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelEmojiUnicode) this.f1525a.parse(new ModelEmojiUnicode());
    }
}
