/*
 * BaseBusiness.java    1.0  2015-11-3
 *
 * 沈阳成林健康科技有限公司
 * 
 */

package com.mnt.business.base;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.mnt.bean.LoginUser;
import com.mnt.common.constants.PublicConfig;
import com.mnt.common.result.ResultCode;
import com.mnt.common.thread.TokenManager;
import com.mnt.service.base.BaseService;
import com.mnt.service.customer.CustomerService;
import com.mnt.service.customer.DiagnosticReportService;
import com.mnt.service.customer.FtpService;
import com.mnt.service.customer.ManagerReportTypeService;
import com.mnt.service.customer.QuestionAnswerService;
import com.mnt.service.customer.QuestionReportService;
import com.mnt.service.customer.exam.CustomerAbnormityService;
import com.mnt.service.customer.exam.ExamSyncService;
import com.mnt.service.customer.exam.ExaminationResultService;
import com.mnt.service.customer.exam.HealthManageReportService;
import com.mnt.service.customer.exam.HealthManagerDietService;
import com.mnt.service.customer.exam.HealthManagerDiseaseRiskService;
import com.mnt.service.customer.exam.HealthManagerLifeSolutionService;
import com.mnt.service.customer.exam.HealthManagerRiskFactorService;
import com.mnt.service.customer.exam.HealthManagerSportSolutionService;
import com.mnt.service.customer.exam.HealthManagerSummaryService;
import com.mnt.service.customer.exam.HealthManagerTargetContrastService;
import com.mnt.service.customer.exam.HealthManagerTargetService;
import com.mnt.service.customer.exam.ItemClassifyService;
import com.mnt.service.customer.exam.ItemService;
import com.mnt.service.customer.exam.NorthInternationService;
import com.mnt.service.customer.exam.NortheastInternationalExamSyncService;
import com.mnt.service.customer.exam.OriginComboService;
import com.mnt.service.customer.exam.OriginDeptService;
import com.mnt.service.customer.exam.OriginFeesService;
import com.mnt.service.customer.exam.OriginItemService;
import com.mnt.service.customer.exam.OriginWorkunitService;
import com.mnt.service.customer.exam.ReportUploadService;
import com.mnt.service.customer.exam.RiskElementsService;
import com.mnt.service.customer.exam.RiskLevelService;
import com.mnt.service.customer.exam.TeamExamineAbnormalDetectionRatioService;
import com.mnt.service.customer.exam.TeamExamineAgeDistributionService;
import com.mnt.service.customer.exam.TeamExamineLifeTypeService;
import com.mnt.service.customer.exam.TeamExamineReportService;
import com.mnt.service.customer.exam.TeamExamineRiskAssessService;
import com.mnt.service.customer.exam.TeamExamineTargetContrastService;
import com.mnt.service.customer.exam.TeamExamineTargetService;
import com.mnt.service.customer.exam.TmpExaminationDataService;
import com.mnt.service.customer.exam.ZKCheckJgService;
import com.mnt.service.customer.examitem.diet.analyse.DietAnalyseService;
import com.mnt.service.customer.examitem.diet.record.DietRecordService;
import com.mnt.service.customer.examitem.inbody.record.InbodyRecordService;
import com.mnt.service.customer.examresult.ExamRecordService;
import com.mnt.service.customer.examresult.ExamResultService;
import com.mnt.service.customer.examresult.InspectionResultService;
import com.mnt.service.customer.order.OrderService;
import com.mnt.service.customer.plan.DiagnosisService;
import com.mnt.service.customer.plan.PlanService;
import com.mnt.service.customer.plan.ProductCatalogService;
import com.mnt.service.exception.CoreServiceException;
import com.mnt.service.master.DiseaseService;
import com.mnt.service.master.FixedContentService;
import com.mnt.service.master.FoodcardService;
import com.mnt.service.master.InspectItemService;
import com.mnt.service.master.InspectItemTempletService;
import com.mnt.service.master.InterveneDiseaseService;
import com.mnt.service.master.IntervenePointsService;
import com.mnt.service.master.OptionService;
import com.mnt.service.master.ProblemService;
import com.mnt.service.master.ProductService;
import com.mnt.service.master.QuestionProblemOptionsService;
import com.mnt.service.master.RiskContentService;
import com.mnt.service.master.TemplateService;
import com.mnt.service.master.food.FoodService;
import com.mnt.service.master.plan.NutrientService;
import com.mnt.service.master.plan.PlanDataService;
import com.mnt.service.master.questions.DiagnosticAlgService;
import com.mnt.service.sys.CodeService;
import com.mnt.service.sys.InstitutionService;
import com.mnt.service.sys.LoginService;
import com.mnt.service.sys.SystemParamService;
import com.mnt.service.sys.UserService;
import com.mnt.service.sys.authority.MenuService;

/**
 * 业务层基础公用类
 * 
 * @author zy
 * @version 1.0
 * 
 *          变更履历：
 *          v1.0 2015-11-3 zy 初版
 */
public abstract class BaseBusiness {

    @Resource
    public PublicConfig publicConfig;

    @Resource
    private LoginService loginCacheService;

    @Resource
    public SystemParamService systemParamService;

    @Resource
    public QuestionAnswerService questionAnswerService;

    @Resource
    public CustomerService customerService;

    @Resource
    public QuestionReportService questionReportService;

    @Resource
    public DiagnosticAlgService diagnosticAlgService;

    @Resource
    public DiagnosticReportService diagnosticReportService;

    @Resource
    public DietRecordService dietRecordService;

    @Resource
    public DietAnalyseService dietAnalyseService;

    @Resource
    public FoodService foodService;

    @Resource
    public ItemService itemService;

    @Resource
    public OriginItemService originItemService;

    @Resource
    public OriginDeptService originDeptService;

    @Resource
    public CustomerAbnormityService customerAbnormityService;

    @Resource
    public RiskLevelService riskLevelService;

    @Resource
    public PlanDataService planDataService;

    @Resource
    public ProblemService problemService;

    @Resource
    public OptionService optionService;

    @Resource
    public InspectItemTempletService inspectItemTempletService;

    @Resource
    public DiseaseService diseaseService;

    @Resource
    public InspectItemService inspectItemService;

    @Resource
    public DiagnosisService diagnosisService;

    @Resource
    public PlanService planService;

    @Resource
    public ProductService productService;

    @Resource
    public InstitutionService insService;

    @Resource
    public MenuService menuService;

    @Resource
    public OrderService orderService;

    @Resource
    public InbodyRecordService inbodyRecordService;

    @Resource
    public BaseService baseService;

    @Resource
    public ExamRecordService examRecordService;

    @Resource
    public HealthManageReportService healthManageReportService;

    @Resource
    public QuestionProblemOptionsService questionProblemOptionsService;

    @Resource
    public HealthManagerSummaryService healthManagerSummaryService;

    @Resource
    public RiskElementsService riskElementsService;

    @Resource
    public HealthManagerTargetContrastService managerTargetContrastService;

    @Resource
    public HealthManagerSportSolutionService healthManagerSportSolutionService;

    @Resource
    public HealthManagerDiseaseRiskService healthManagerDiseaseRiskService;

    @Resource
    public HealthManagerLifeSolutionService healthManagerLifeSolutionService;

    @Resource
    public HealthManagerTargetService healthManagerTargetService;

    @Resource
    public HealthManagerRiskFactorService healthManagerRiskFactorService;

    @Resource
    public HealthManagerDietService healthManagerDietService;

    @Resource
    public ExamSyncService examSyncService;

    @Resource
    public FoodcardService foodcardService;

    @Resource
    public FtpService ftpService;

    @Resource
    public OriginWorkunitService originWorkunitService;

    @Resource
    public TeamExamineReportService teamExamineReportService;

    @Resource
    public OriginComboService originComboService;

    @Resource
    public FixedContentService fixedContentService;

    @Resource
    public OriginFeesService originFeesService;

    @Resource
    public TeamExamineAgeDistributionService teamExamineAgeDistributionService;

    @Resource
    public ExamResultService examResultService;

    @Resource
    public TeamExamineAbnormalDetectionRatioService teamExamineAbnormalDetectionRatioService;

    @Resource
    public TeamExamineTargetService teamExamineTargetService;

    @Resource
    public TeamExamineTargetContrastService teamExamineTargetContrastService;

    @Resource
    public TeamExamineRiskAssessService teamExamineRiskAssessService;

    @Resource
    public TeamExamineLifeTypeService teamExamineLifeTypeService;

    @Resource
    public InterveneDiseaseService interveneDiseaseService;

    @Resource
    public TemplateService templateService;

    @Resource
    public IntervenePointsService intervenePointsService;

    @Resource
    public ZKCheckJgService zkCheckJgService;

    @Resource
    public TmpExaminationDataService tmpExaminationDataService;

    @Resource
    public ExaminationResultService examinationResultService;

    @Resource
    public NortheastInternationalExamSyncService northeastInternationalExamSyncService;

    @Resource
    public NorthInternationService northInternationService;

    @Resource
    public CodeService codeService;

    @Resource
    public InspectionResultService inspectionResultService;

    @Resource
    public RiskContentService riskContentService;

    @Resource
    public ProductCatalogService productCatalogService;

    @Resource
    public NutrientService nutrientService;

    @Resource
    public ManagerReportTypeService managerReportTypeService;

    @Resource
    public UserService userService;

    @Resource
    public ItemClassifyService itemClassifyServie;

    @Resource
    public ReportUploadService reportUploadService;

    /**
     * 
     * 获取参数值
     * 
     * @author zy
     * @param paramCode
     *            参数编码
     * @return 参数值
     */
    public String getParamValue(String paramCode) {
        return systemParamService.getSystemParam(paramCode).getParamValue();
    }

    public String getToken() {
        return TokenManager.getCurrHashMap().get(Thread.currentThread());
    }

    public LoginUser getLoginUser() {
        String token = this.getToken();
        if (StringUtils.isNotEmpty(token)) {
            LoginUser loginUser = loginCacheService.getLogin(token);
            if (null == loginUser) {
                throw new CoreServiceException(ResultCode.ERROR_90006);
            }
            return loginUser;
        }
        throw new CoreServiceException(ResultCode.ERROR_90006);
    }
}
