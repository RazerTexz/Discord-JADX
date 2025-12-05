package p007b.p008a.p033m.p034a.p035h0;

import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.ModelEmojiUnicode;

/* compiled from: lambda */
/* renamed from: b.a.m.a.h0.b */
/* loaded from: classes.dex */
public final /* synthetic */ class C1146b implements Model.JsonReader.ItemFactory {

    /* renamed from: a */
    public final /* synthetic */ Model.JsonReader f1526a;

    public /* synthetic */ C1146b(Model.JsonReader jsonReader) {
        this.f1526a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        return (ModelEmojiUnicode) this.f1526a.parse(new ModelEmojiUnicode());
    }
}
