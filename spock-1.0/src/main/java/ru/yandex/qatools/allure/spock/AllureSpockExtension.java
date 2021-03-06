package ru.yandex.qatools.allure.spock;

import org.spockframework.runtime.extension.AbstractGlobalExtension;
import org.spockframework.runtime.model.SpecInfo;
import ru.yandex.qatools.allure.config.AllureConfig;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 24.06.14
 */
public class AllureSpockExtension extends AbstractGlobalExtension {

    @Override
    public void start() {
        TargetDirCleaner.deleteTestReports(AllureConfig.newInstance().getResultsDirectory());
    }

    @Override
    public void visitSpec(SpecInfo spec) {
        spec.addListener(new SpockRunListener());
    }
}
