package p007b.p008a.p033m.p034a.p035h0;

import android.os.Parcelable;
import com.discord.models.domain.Model;
import com.discord.models.domain.emoji.ModelEmojiUnicode;

/* JADX INFO: renamed from: b.a.m.a.h0.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1147c implements Model.JsonReader.ItemFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Model.JsonReader f1527a;

    public /* synthetic */ C1147c(Model.JsonReader jsonReader) {
        this.f1527a = jsonReader;
    }

    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
    public final Object get() {
        Model.JsonReader jsonReader = this.f1527a;
        Parcelable.Creator<ModelEmojiUnicode> creator = ModelEmojiUnicode.CREATOR;
        return jsonReader.nextString(null);
    }
}
