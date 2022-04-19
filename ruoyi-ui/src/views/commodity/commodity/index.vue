<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名" prop="pnamech">
        <el-input
          v-model="queryParams.pnamech"
          placeholder="请输入商品名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="英文名称" prop="pnameen">
        <el-input
          v-model="queryParams.pnameen"
          placeholder="请输入英文名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="品牌" prop="brand">
        <el-input
          v-model="queryParams.brand"
          placeholder="请输入品牌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产地" prop="origin">
        <el-input
          v-model="queryParams.origin"
          placeholder="请输入产地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="MDL" prop="mdl">
        <el-input
          v-model="queryParams.mdl"
          placeholder="请输入MDL"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="型号" prop="model">
        <el-input
          v-model="queryParams.model"
          placeholder="请输入型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商名" prop="sname">
        <el-input
          v-model="queryParams.sname"
          placeholder="请输入供应商名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="供应商id" prop="supplierid">
        <el-input
          v-model="queryParams.supplierid"
          placeholder="请输入供应商id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品单位" prop="unit">
        <el-input
          v-model="queryParams.unit"
          placeholder="请输入商品单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="纯度" prop="purity">
        <el-input
          v-model="queryParams.purity"
          placeholder="请输入纯度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="存储温度" prop="storetem">
        <el-input
          v-model="queryParams.storetem"
          placeholder="请输入存储温度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="关键词" prop="keywords">
        <el-input
          v-model="queryParams.keywords"
          placeholder="请输入关键词"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最小包装数量" prop="minisize">
        <el-input
          v-model="queryParams.minisize"
          placeholder="请输入最小包装数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入商品价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销量" prop="sales">
        <el-input
          v-model="queryParams.sales"
          placeholder="请输入销量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货号" prop="itemno">
        <el-input
          v-model="queryParams.itemno"
          placeholder="请输入货号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规格" prop="specs">
        <el-input
          v-model="queryParams.specs"
          placeholder="请输入规格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="货期" prop="dtime">
        <el-date-picker clearable
          v-model="queryParams.dtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择货期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="修改时间" prop="updateDate">
        <el-date-picker clearable
          v-model="queryParams.updateDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择修改时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="添加时间" prop="createDate">
        <el-date-picker clearable
          v-model="queryParams.createDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择添加时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['commodity:commodity:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['commodity:commodity:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['commodity:commodity:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['commodity:commodity:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="commodityList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商品ID" align="center" prop="id" />
      <el-table-column label="商品名" align="center" prop="pnamech" />
      <el-table-column label="英文名称" align="center" prop="pnameen" />
      <el-table-column label="品牌" align="center" prop="brand" />
      <el-table-column label="产地" align="center" prop="origin" />
      <el-table-column label="MDL" align="center" prop="mdl" />
      <el-table-column label="型号" align="center" prop="model" />
      <el-table-column label="供应商名" align="center" prop="sname" />
      <el-table-column label="供应商id" align="center" prop="supplierid" />
      <el-table-column label="商品单位" align="center" prop="unit" />
      <el-table-column label="纯度" align="center" prop="purity" />
      <el-table-column label="存储温度" align="center" prop="storetem" />
      <el-table-column label="关键词" align="center" prop="keywords" />
      <el-table-column label="最小包装数量" align="center" prop="minisize" />
      <el-table-column label="商品价格" align="center" prop="price" />
      <el-table-column label="销量" align="center" prop="sales" />
      <el-table-column label="货号" align="center" prop="itemno" />
      <el-table-column label="规格" align="center" prop="specs" />
      <el-table-column label="货期" align="center" prop="dtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改时间" align="center" prop="updateDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="添加时间" align="center" prop="createDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['commodity:commodity:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['commodity:commodity:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商品管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品名" prop="pnamech">
          <el-input v-model="form.pnamech" placeholder="请输入商品名" />
        </el-form-item>
        <el-form-item label="英文名称" prop="pnameen">
          <el-input v-model="form.pnameen" placeholder="请输入英文名称" />
        </el-form-item>
        <el-form-item label="品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="产地" prop="origin">
          <el-input v-model="form.origin" placeholder="请输入产地" />
        </el-form-item>
        <el-form-item label="MDL" prop="mdl">
          <el-input v-model="form.mdl" placeholder="请输入MDL" />
        </el-form-item>
        <el-form-item label="型号" prop="model">
          <el-input v-model="form.model" placeholder="请输入型号" />
        </el-form-item>
        <el-form-item label="供应商名" prop="sname">
          <el-input v-model="form.sname" placeholder="请输入供应商名" />
        </el-form-item>
        <el-form-item label="供应商id" prop="supplierid">
          <el-input v-model="form.supplierid" placeholder="请输入供应商id" />
        </el-form-item>
        <el-form-item label="商品单位" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入商品单位" />
        </el-form-item>
        <el-form-item label="纯度" prop="purity">
          <el-input v-model="form.purity" placeholder="请输入纯度" />
        </el-form-item>
        <el-form-item label="存储温度" prop="storetem">
          <el-input v-model="form.storetem" placeholder="请输入存储温度" />
        </el-form-item>
        <el-form-item label="关键词" prop="keywords">
          <el-input v-model="form.keywords" placeholder="请输入关键词" />
        </el-form-item>
        <el-form-item label="最小包装数量" prop="minisize">
          <el-input v-model="form.minisize" placeholder="请输入最小包装数量" />
        </el-form-item>
        <el-form-item label="商品价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入商品价格" />
        </el-form-item>
        <el-form-item label="销量" prop="sales">
          <el-input v-model="form.sales" placeholder="请输入销量" />
        </el-form-item>
        <el-form-item label="货号" prop="itemno">
          <el-input v-model="form.itemno" placeholder="请输入货号" />
        </el-form-item>
        <el-form-item label="规格" prop="specs">
          <el-input v-model="form.specs" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="货期" prop="dtime">
          <el-date-picker clearable
            v-model="form.dtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择货期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改时间" prop="updateDate">
          <el-date-picker clearable
            v-model="form.updateDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择修改时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="添加时间" prop="createDate">
          <el-date-picker clearable
            v-model="form.createDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择添加时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCommodity, getCommodity, delCommodity, addCommodity, updateCommodity } from "@/api/commodity/commodity";

export default {
  name: "Commodity",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 商品管理表格数据
      commodityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        pnamech: null,
        pnameen: null,
        brand: null,
        origin: null,
        mdl: null,
        model: null,
        sname: null,
        supplierid: null,
        unit: null,
        purity: null,
        storetem: null,
        keywords: null,
        minisize: null,
        price: null,
        sales: null,
        itemno: null,
        specs: null,
        dtime: null,
        updateDate: null,
        createDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        pnamech: [
          { required: true, message: "商品名不能为空", trigger: "blur" }
        ],
        brand: [
          { required: true, message: "品牌不能为空", trigger: "blur" }
        ],
        model: [
          { required: true, message: "型号不能为空", trigger: "blur" }
        ],
        sname: [
          { required: true, message: "供应商名不能为空", trigger: "blur" }
        ],
        supplierid: [
          { required: true, message: "供应商id不能为空", trigger: "blur" }
        ],
        unit: [
          { required: true, message: "商品单位不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "商品价格不能为空", trigger: "blur" }
        ],
        sales: [
          { required: true, message: "销量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商品管理列表 */
    getList() {
      this.loading = true;
      listCommodity(this.queryParams).then(response => {
        this.commodityList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        pnamech: null,
        pnameen: null,
        brand: null,
        origin: null,
        mdl: null,
        model: null,
        sname: null,
        supplierid: null,
        unit: null,
        purity: null,
        storetem: null,
        keywords: null,
        minisize: null,
        price: null,
        sales: null,
        itemno: null,
        specs: null,
        dtime: null,
        updateDate: null,
        createDate: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCommodity(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商品管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCommodity(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCommodity(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除商品管理编号为"' + ids + '"的数据项？').then(function() {
        return delCommodity(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('commodity/commodity/export', {
        ...this.queryParams
      }, `commodity_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
