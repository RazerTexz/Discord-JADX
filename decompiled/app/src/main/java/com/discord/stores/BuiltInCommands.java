package com.discord.stores;

import com.discord.R;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.commands.BuiltInCommand;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreApplicationCommands.kt */
/* loaded from: classes2.dex */
public final class BuiltInCommands implements BuiltInCommandsProvider {
    public static final long BUILT_IN_APP_ID = -1;
    public static final long FRECENCY_APP_ID = -2;
    private final Application builtInApplication;
    private final List<ApplicationCommand> builtInCommands;

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.BuiltInCommands$createAppendToEndSlashCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Map<String, ? extends Object>, String> {
        public final /* synthetic */ String $replacement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$replacement = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Map<String, ? extends Object> map) {
            return invoke2(map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Map<String, ? extends Object> map) {
            m.checkNotNullParameter(map, "commandOptions");
            StringBuilder sb = new StringBuilder();
            Object obj = map.get("message");
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(' ');
            sb.append(this.$replacement);
            return sb.toString();
        }
    }

    /* compiled from: StoreApplicationCommands.kt */
    /* renamed from: com.discord.stores.BuiltInCommands$createWrappedSlashCommand$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Map<String, ? extends Object>, String> {
        public final /* synthetic */ String $wrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$wrapper = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Map<String, ? extends Object> map) {
            return invoke2(map);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(Map<String, ? extends Object> map) {
            m.checkNotNullParameter(map, "commandOptions");
            StringBuilder sb = new StringBuilder();
            sb.append(this.$wrapper);
            Object obj = map.get("message");
            if (obj == null) {
                obj = "";
            }
            sb.append(obj);
            sb.append(this.$wrapper);
            return sb.toString();
        }
    }

    public BuiltInCommands() {
        List<ApplicationCommand> listListOf = n.listOf((Object[]) new ApplicationCommand[]{createAppendToEndSlashCommand(-1L, "shrug", Integer.valueOf(R.string.command_shrug_description), Integer.valueOf(R.string.command_shrug_message_description), "¯\\\\_(ツ)\\_/¯"), createAppendToEndSlashCommand(-2L, "tableflip", Integer.valueOf(R.string.command_tableflip_description), Integer.valueOf(R.string.command_tableflip_message_description), "(╯°□°）╯︵ ┻━┻"), createAppendToEndSlashCommand(-3L, "unflip", Integer.valueOf(R.string.command_tableunflip_description), Integer.valueOf(R.string.command_tableunflip_message_description), "┬─┬ ノ( ゜-゜ノ)"), createWrappedSlashCommand(-5L, "me", Integer.valueOf(R.string.command_me_description), Integer.valueOf(R.string.command_me_message_description), "_"), createWrappedSlashCommand(-6L, "spoiler", Integer.valueOf(R.string.command_spoiler_description), Integer.valueOf(R.string.command_spoiler_message_description), "||")});
        this.builtInCommands = listListOf;
        this.builtInApplication = new Application(-1L, "Built-In", null, Integer.valueOf(R.drawable.ic_slash_command_24dp), listListOf.size(), null, true, 36, null);
    }

    private final ApplicationCommand createAppendToEndSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String replacement) {
        return new BuiltInCommand(String.valueOf(id2), -1L, name, descriptionRes, d0.t.m.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, false, false, null, null, null, false, null, null, 4036, null)), new AnonymousClass1(replacement));
    }

    private final ApplicationCommand createWrappedSlashCommand(long id2, String name, Integer descriptionRes, Integer optionDescriptionRes, String wrapper) {
        return new BuiltInCommand(String.valueOf(id2), -1L, name, descriptionRes, d0.t.m.listOf(new ApplicationCommandOption(ApplicationCommandType.STRING, "message", null, optionDescriptionRes, true, false, null, null, null, false, null, null, 4036, null)), new AnonymousClass1(wrapper));
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public Application getBuiltInApplication() {
        return this.builtInApplication;
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public List<ApplicationCommand> getBuiltInCommands() {
        return this.builtInCommands;
    }

    @Override // com.discord.stores.BuiltInCommandsProvider
    public Application getFrecencyApplication() {
        return new Application(-2L, "Frequently Used", null, Integer.valueOf(R.drawable.ic_recent_24dp), 0, null, true, 36, null);
    }
}
